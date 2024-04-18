import './App.scss';
import {Outlet} from 'react-router-dom';

import {Footer} from './components/footer';
import {Header} from './components/header';
import {ProgramList} from './components/programlist';

function App() {
  return (
    <>
      <Header />
      <div className="main">
        <div className="content">
          <Outlet />
          <ProgramList />
        </div>
      </div>
      <Footer />
    </>
  );
}

export default App;
