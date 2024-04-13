import React from 'react';
import './ProgramList.scss';

export const ProgramList: React.FC = () => {
  return (
    <section className="programs-section">
      <h2>
        Our <em className="highlight">Programs</em>
      </h2>
      <ul className="programs">
        <li className="program">
          <h3>1000 Kids Coding</h3>
          <p>
            The Code Differently 1000 Kids Coding program was created to expose
            New Castle County students to computing and programming. The 1000
            Kids Coding courses are designed for all experience levels, no
            experience required.
          </p>
        </li>
        <li className="program">
          <h3>Return Ready</h3>
          <p>
            The Code Differently Workforce Training Initiatives were created to
            help individuals underrepresented in tech reinvent their skills to
            align with the changing workforce market. If you are ready to start
            your tech journey, join our talent community today.
          </p>
        </li>
        <li className="program">
          <h3>Pipeline DevShops</h3>
          <p>
            Pipeline DevShop is a youth work-based learning program. Youth
            participants experience working in a real software development
            environment while sharpening their technology and soft skills.
          </p>
        </li>
        <li className="program">
          <h3>Platform Programs</h3>
          <p>
            Platform programs are designed for high school graduates, college
            students, career changers, or professionals looking to develop the
            technology job readiness skills for today’s workforce.
          </p>
        </li>
      </ul>
    </section>
  );
};
