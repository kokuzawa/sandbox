/*
 * Copyright 2019 Katsumi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import React from "react";
import Todo from "./Todo";
import * as TodoActions from "./actions/TodoAction";
import todoStore from "./stores/TodoStore";

class Todos extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            todos: todoStore.getAll()
        };
        this.getTodos = this.getTodos.bind(this);
        this.reloadTodos = this.reloadTodos.bind(this);
    }

    componentDidMount() {
        todoStore.on("change", this.getTodos);
        console.log("count", todoStore.listenerCount("change"));
    }

    componentWillUnmount() {
        todoStore.removeListener("change", this.getTodos);
    }

    getTodos() {
        this.setState({todos: todoStore.getAll()});
    }

    reloadTodos() {
        TodoActions.reloadTodos();
    }

    render() {
        const TodoComponents = this.state.todos.map((todo) => {
            return <Todo key={todo.id} {...todo}/>;
        });
        return (
            <div>
                <button onClick={this.reloadTodos}>Reload</button>
                <h1>Todos</h1>
                <ul>{TodoComponents}</ul>
            </div>
        );
    }
}

export default Todos;