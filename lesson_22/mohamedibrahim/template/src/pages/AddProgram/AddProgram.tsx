import './AddProgram.scss';
import React from 'react';


export const AddProgram: React.FC = () => {
  return (
    <article>
      <h1 className="page-title"><em className="highlight">Add Programs</em></h1>
      <h3>Program Name</h3>
      <input className="add-program-input-name" type="text" placeholder="Enter Program Name" id ="programname"></input>
      <h3>Program Discription</h3>
      <input className="add-program-input-discription" type="text" placeholder="Enter Program Discription" id ="programdiscription"></input>
      <button className="add-program-button" onClick={() => {
        const programName = (document.getElementById('programname') as HTMLInputElement).value;
        const programDiscription = (document.getElementById('programdiscription') as HTMLInputElement).value;
        const program = {
          title: programName,
          description: programDiscription
        };
        fetch('http://localhost:4000/programs', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(program),
        })
          .then((response) => response.json())
          document.getElementById('programname').value = '';
          document.getElementById('programdiscription').value = '';
          alert('Program added successfully');
      }}>Add Program</button>
    </article>
  );
};