import './Program.scss';
import { useQuery } from '@tanstack/react-query';
import {Program as ProgramType} from '@code-differently/types';
import React from 'react';


const query = useQuery({ queryKey: ['program'], queryFn: async () => {
    //  queryFn is an asynchronous function that fetches program data from the server
const res = await fetch('http://localhost:4000/programs');
//Inside the queryFn, an HTTP GET request is made to 'http://localhost:4000/programs'
      return await res.json();
      // The response is then converted to JSON format and returned.
      } });
  
      return (
        <>
        {query.data?.map((p: ProgramType) => <li className="program">
            // Map over the data returned from the query, if available.
            // For each item in the data array, render a list item with the class 'program'.
           <h3>{p.title}</h3>
          <p>{p.description}</p>   
        </li>)}
        </>
      );
    
      // Borrowed some code from Rich