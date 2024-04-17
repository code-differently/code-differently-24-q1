# Lesson 22

## Lecture Resources

* [Writing Markup with JSX (react.dev)](https://react.dev/learn/writing-markup-with-jsx)
* Guides for [React Query](react-query-link), [React Router](react-router-link).
* [Javascript Promises vs Async Await EXPLAINED (in 5 minutes)](https://www.youtube.com/watch?v=li7FzDHYZpc) - YouTube
* _[Optional]_ Creating a new website using [Vite](https://vitejs.dev/guide/).

## Homework

* Review the above [lecture resources](#lecture-resources) to review concepts introduced in class.
* Complete the [Introduction to React](#introduction-to-react) assignment.

## Introduction to React
This exercise will give you hands-on experience with the React framework and supporting tools to enhance a dynamic front-end application that communicates with a backend API. We will need to leverage [React Query](react-query-link), [React Router](react-router-link), and [Vite](vite-link) tie everything together.

### Starting the servers

1. Copy the React [template](./template/) folder to your own unique folder. Make necessary code changes in your folder only. 
2. Install the [API server](./api/) using `npm install` and then run it using the `npm run dev` command. 
3. Install the React web server in your copy using `npm install` and then run it using the `npm run dev` command.

### Create new components
3. Modify the [Home](./template/src/pages/Home/Home.tsx) component to create new `Program` and `ProgramList` components. The needed HTML and CSS has already been provided for you.
  - The `Program` component should allow you to configure the title and description to display.
  - The `ProgramList` component should call the [API](./api/src/server.ts)  to retrieve a list of programs and render each using the `Program` component.
  - You can reference the types/interfaces used in the API by importing from the `@code-differently/types` package. 

### Create a page for adding new programs
4. Create a new page (similar to the Home page component) that allows you to provide a new title and description and then use the API to add it to the existing list of programs.
5. Add a link to the new page in the [Header](./template/src/components/header/Header.tsx) component that navigates to the new page.

> [!NOTE]
> You can use the [React Router tutorial](https://reactrouter.com/en/main/start/tutorial#updating-contacts-with-formdata) to learn how to handle form submissions. You can also use the [React Query guide](https://tanstack.com/query/latest/docs/framework/react/guides/mutations) to learn how leverage mutation to post to an API. 

[react-query-link]: https://tanstack.com/query/latest/docs/framework/react/quick-start
[react-router-link]: https://reactrouter.com/en/main/start/tutorial
[vite-link]: https://vitejs.dev/guide/env-and-mode.html