import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from 'react-router-dom';
import Layout from './home/Layout'

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/:id" children={<Layout />} /> 
        </Switch>
      </Router>
    </div>
  );
}

export default App;
