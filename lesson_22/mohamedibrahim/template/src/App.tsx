import './App.scss';
import {AddProgram} from '@/pages/AddProgram/AddProgram';
import {Home} from '@/pages/Home/Home';
import {Outlet, Routes} from 'react-router-dom';
import {Route, BrowserRouter as Router,
} from 'react-router-dom';

import {Footer} from './components/footer';
import {Header} from './components/header';
import {ProgramList} from './components/programlist';

export default function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route index element={<Home />} />
        <Route path="/" element={<Home />} />
        <Route path="/add-program" element={<AddProgram />} />
        <Route path="/signin" element={<AddProgram />} />
        <Route path="/About" element={<ProgramList />} />
      </Routes>
      <Footer />
    </>
  );
}
