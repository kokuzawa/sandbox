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

import dispatcher from "../MyDispatcher";

export function createTodo(text) {
    dispatcher.dispatch({
        type: "CREATE_TODO",
        text: text
    })
}

export function reloadTodos() {
    // ここでデータをFETCHするが、サービスを用意していないので、
    // setTimeoutで擬似的に処理を遅延し、非同期な処理を実装する。
    setTimeout(() => {
        dispatcher.dispatch({type: "RECEIVE_TODOS", todos: [
            {
                id: 8484848484,
                text: "Go Shopping Again",
                complete: false
            },
            {
                id: 6262627272,
                text: "Hug Wife",
                complete: true
            },
        ]});
    }, 1000);
}