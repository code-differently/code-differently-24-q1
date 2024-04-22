import './Program.scss';
import {Program as ProgramType} from '@code-differently/types';
import {useQuery} from '@tanstack/react-query';
import React from 'react';

export const Program: React.FC = () => {
  // Uses `useQuery` hook to fetch data from the API and render a list of program items.

  const query = useQuery({
    queryKey: ['program'],
    queryFn: async () => {
      const res = await fetch('http://localhost:4000/programs');
      return await res.json();
    },
  });
  // iterates over each item in the data array and for each item returns an <li> element.
  return (
    <>
      {query.data?.map((p: ProgramType) => (
        <li className="program">
          <h3>{p.title}</h3>
          <p>{p.description}</p>
        </li>
      ))}
    </>
  );
};
