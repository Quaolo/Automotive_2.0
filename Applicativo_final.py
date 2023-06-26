import requests
import wikipedia
import mysql.connector

headers = {                 
    'User-Agent': 'script'
}

images_types = ['image/jpeg', 'image/jpg', 'image/png'] # Valid image types

def check_img_format(input_img): # Check if the image have a valid extension for being saved
        data = requests.get(input_img, headers = headers, stream = True)
        
        if(data.headers['Content-Type'] in images_types):        
            return True
        else:             
            return False

def insert_images(myConnection, myCursor, car_id, car_description, car_list): # Function for insert data into table
    
    sql_insert_query = """ INSERT INTO wikipedia_car
                    (car_id, description, car_img_1, car_img_2, car_img_3, car_img_4, car_img_5) VALUES (%s,%s,%s,%s,%s,%s,%s)"""
                    
    # Create a list of car_id, car_description and five "NONE" parameters
    values = [car_id, car_description] + [None] * 5
    
    # Assign image values from car_list fup to a maximum of five images
    for i in range(min(5, len(car_list))):
        values[i + 2] = car_list[i] 
    
    result = myCursor.execute(sql_insert_query, values)  # Cursor used for "insert" query 
    myConnection.commit()                                # Commit the query

def main():
    # Connection to database
    try:                                                 
        myDB = mysql.connector.connect(host='localhost',
                                            user='root',
                                            password='',
                                            database='test')
        
        count_cursor = myDB.cursor()
        search_cursor = myDB.cursor(buffered = True)
        
        count_query = "SELECT COUNT(*) FROM car" # Check the number of rows of the main table 
        count_cursor.execute(count_query)        # Cursor used for the query "count"
        num_rows = count_cursor.fetchone()[0]
        print("Numero di righe:", num_rows)
        
        for i in range(1, 30): #range(1, num_rows + 1):      
            search_query = "SELECT id, name FROM car WHERE id = %s" # Query for the id and the name of every car 
            search_cursor.execute(search_query, (i,))               # Cursor used for the query "search"
            
            tuple = search_cursor.fetchone() # Complete list of {id, name} (tuple)
            
            insert_cursor = myDB.cursor()   # Cursor used for the query "insert"
            id = tuple[0]                   # Tuple[0] refers to the first element in tuples from rows_list     
                                            # The id is usefull for searching the car from the second table
            try:                                
                car_page = wikipedia.page(tuple[1])   # Tuple[1] refers to the second element in tuples from rows_list
                print(id, car_page) 
                summary = wikipedia.summary(tuple[1]) # The name is used to search and take images and summaries with Wikipedia API
                
                if car_page.images: # Check if the wikipedia page contains at least one image*
                        images_list = []
                        
                        for i in range(max(5, len(car_page.images))):
                            if(check_img_format(car_page.images[i])):
                                images_list.append(car_page.images[i])
                            
                        insert_images(myDB, insert_cursor, id, summary, images_list)    # Call the insert function, adding id,  
                                                                                        # summary and images into database
                        
                else:                                        # In case page haven't images
                    continue
                
            except wikipedia.exceptions.PageError:           # Exception in case not found a page for the name searched
                continue
            except wikipedia.exceptions.DisambiguationError: # Exception in case of disambiguation for the name searched
                continue
            
            insert_cursor.close()   # Close the insert_cursor

    except mysql.connector.Error as error:                                # Exception in case of a connection error
        print("Failed inserting data into MySQL table {}".format(error))
    
    finally:
        if myDB.is_connected():     
            search_cursor.close()   # Close the search_cursor
            count_cursor.close()    # Close the count_cursor
            myDB.close()            # Close the connection to database if 
            print("MySQL connection is closed")
            
if __name__ == "__main__":
    main()