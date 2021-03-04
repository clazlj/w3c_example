package org.w3cschool.spring.event;

import org.springframework.context.ApplicationEvent;

public class RestEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public RestEvent(RestEventParam source) {
        super(source);
    }
}

class RestEventParam{
    private String msg;

    private String reason;

    public RestEventParam(String msg, String reason) {
        this.msg = msg;
        this.reason = reason;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}


