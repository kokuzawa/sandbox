/*
 * Copyright 2018 Katsumi
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

package org.katsumi.rest;

import org.katsumi.rest.request.TestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.DayOfWeek;
import java.util.HashMap;

@Path("/test")
public class TestResource
{
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@NotNull @Valid TestParam param)
    {
        final HashMap<DayOfWeek, String> map = new HashMap<>();
        map.put(DayOfWeek.MONDAY, "月");
        map.put(DayOfWeek.TUESDAY, "火");
        map.put(DayOfWeek.WEDNESDAY, "水");
        map.put(DayOfWeek.THURSDAY, "木");
        map.put(DayOfWeek.FRIDAY, "金");
        map.put(DayOfWeek.SATURDAY, "土");
        map.put(DayOfWeek.SUNDAY, "日");

        final HashMap<String, String> response = new HashMap<>();
        response.put("dayOfWeek", map.get(param.getDayOfWeek()));
        return Response.ok(response).build();
    }
}
