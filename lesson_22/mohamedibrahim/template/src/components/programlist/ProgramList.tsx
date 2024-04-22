import './ProgramList.scss';
import React from 'react';
import {Program} from '@/components/program';


export const ProgramList: React.FC = () => {
    return (<section className="programs-section">
      <h2>
        Our <em className="highlight">Programs</em>
      </h2>
      <ul className="programs">
        <Program/>
      </ul>
    </section>
    );
};