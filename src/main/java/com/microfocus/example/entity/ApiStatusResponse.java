/*
        Java Web App

        Copyright (C) 2020 Micro Focus or one of its affiliates

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.microfocus.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ApiStatusResponse {

    private Boolean success;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime timeStamp;
    private ArrayList<String> errors;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public static final class ApiResponseBuilder {
        private Boolean success;
        private LocalDateTime timeStamp;
        private ArrayList<String> errors;

        public ApiResponseBuilder() {
        }

        public static ApiResponseBuilder anApiResponse() {
            return new ApiResponseBuilder();
        }

        public ApiResponseBuilder withSuccess(Boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseBuilder atTime(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public ApiResponseBuilder withErrors(ArrayList<String> errors) {
            this.errors = errors;
            return this;
        }

        public ApiStatusResponse build() {
            ApiStatusResponse apiErrorResponse = new ApiStatusResponse();
            apiErrorResponse.success = this.success;
            apiErrorResponse.timeStamp = this.timeStamp;
            apiErrorResponse.errors = this.errors;
            return apiErrorResponse;
        }
    }
}
