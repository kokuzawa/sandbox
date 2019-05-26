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

import {EventEmitter} from "events";
import dispatcher from "../MyDispatcher";

class TodoStore extends EventEmitter {

    constructor() {
        super();
        this.todos = [
            {
                id: 113464613,
                text: "Go Shopping",
                complete: false
            },
            {
                id: 235684679,
                text: "Pay Water Bills",
                complete: false
            }
        ];
    }

    getAll() {
        return this.todos;
    }

    createTodo(text) {
        const id = Date.now();
        this.todos.push({
            id: id,
            text: text,
            complete: false
        });
        this.emit("change");
    }

    reloadTodos(todos) {
        this.todos = todos;
        this.emit("change");
    }

    handleActions(action) {
        switch (action.type) {
            case "CREATE_TODO": {
                this.createTodo(action.text);
                return;
            }
            case "RECEIVE_TODOS": {
                this.reloadTodos(action.todos);
                return;
            }
            default: {
            }
        }
    }
}

const todoStore = new TodoStore();
dispatcher.register(todoStore.handleActions.bind(todoStore));

// コンソールからdispatcherをグローバルスコープで呼び出せるように
// window.dispatcherにdispatcherインスタンスを格納。
window.dispatcher = dispatcher;

export default todoStore;