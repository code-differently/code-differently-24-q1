import React from 'react';
import './Home.scss';
import {Hero} from './sections/Hero';
import {ProgramList} from './sections/ProgramList';

export const Home: React.FC = () => {
  return (
    <article>
      <Hero />
      <ProgramList />
    </article>
  );
};
