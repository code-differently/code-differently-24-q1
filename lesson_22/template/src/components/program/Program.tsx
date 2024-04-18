import './Program.scss';
import {useQuery} from '@tanstack/react-query';
import React from 'react';
import {Program as ProgramType} from '@code-differently/types';

export const Program: React.FC = () => {
    const query = useQuery({
        queryKey: ['program'],
            queryFn: async () => {const res = await fetch( 'http://localhost:4000/programs');
            return await res.json();
        },
    });

    return (
        <>
            {query.data?.map((p:ProgramType) => (
                <li className="program">
                    <h3>{p.title}</h3>
                    <p>{p.description}</p>
                </li>)
            )}
            <p>meow meow</p>
        </>
    );
};