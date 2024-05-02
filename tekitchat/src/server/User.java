package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Objects;

public class User {
    private final PrintWriter out;
    private final BufferedReader in;
    private final String id;
    private final String ip;

    public User(String id,String ip,PrintWriter out,BufferedReader in) {
        this.id = id;
        this.ip = ip;
        this.out = out;
        this.in = in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public String getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
