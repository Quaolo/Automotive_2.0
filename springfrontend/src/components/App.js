import logo from '../car-logo.svg';
import './App.css';

import Header from './Header';
import AppContent from './AppContent';

function App() {
    return(
        <div className = "App">
            <Header pageTitle = "Automotive 2.0" logoSrc = {logo} />
            <div className = "container-fluid">
                <div className = "row">
                    <div className = "col">
                        <AppContent/>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;