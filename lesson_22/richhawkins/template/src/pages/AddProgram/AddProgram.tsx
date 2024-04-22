import './AddProgram.scss';
import React from 'react';

export const AddProgram: React.FC = () => {
  return (
    <section className="add-program-section">
      <h1 className="add-program-title">Add Program</h1>
      <form className="add-program-form">
        <label>
          Title:
          <input
            className="add-program-title-input"
            type="text"
            name="title"
            placeholder="Enter Title..."
            id="programtitle"
          />
        </label>
        <label>
          Description:
          <div className="wrapper">
            <textarea
              className="add-program-description-input"
              name="description"
              placeholder="Enter Description..."
              id="programdescription"
            />
          </div>
        </label>
        <button
          className="add-program-button"
          onClick={() => {
            const programTitle = (
              document.getElementById('programtitle') as HTMLInputElement
            ).value;
            const programDescription = (
              document.getElementById('programdescription') as HTMLInputElement
            ).value;
            const program = {
              title: programTitle,
              description: programDescription,
            };
            fetch('http://localhost:4000/programs', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(program),
            }).then(response => response.json());
            document.getElementById('programtitle').value = '';
            document.getElementById('programdescription').value = '';
          }}
        >
          Add Program
        </button>
      </form>
    </section>
  );
};
