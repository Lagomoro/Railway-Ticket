package pers.lagomoro.railway_system.entity;

public class Ticket {
    private Integer ticket_id;

    private Integer oid;

    private Integer seat_id;

    private Integer journey;

    private String passenger_name;

    private String passenger_identity;

    private Integer passenger_gid;

    private Integer status;

    public Ticket(Integer ticket_id, Integer oid, Integer seat_id, Integer journey, String passenger_name, String passenger_identity, Integer passenger_gid, Integer status) {
        this.ticket_id = ticket_id;
        this.oid = oid;
        this.seat_id = seat_id;
        this.journey = journey;
        this.passenger_name = passenger_name;
        this.passenger_identity = passenger_identity;
        this.passenger_gid = passenger_gid;
        this.status = status;
    }

    public Ticket() {
        super();
    }

    public Integer getTicketId() {
        return ticket_id;
    }

    public void setTicketId(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSeatId() {
        return seat_id;
    }

    public void setSeatId(Integer seat_id) {
        this.seat_id = seat_id;
    }

    public Integer getJourney() {
        return journey;
    }

    public void setJourney(Integer journey) {
        this.journey = journey;
    }

    public String getPassengerName() {
        return passenger_name;
    }

    public void setPassengerName(String passengerName) {
        this.passenger_name = passenger_name == null ? null : passenger_name.trim();
    }

    public String getPassengerIdentity() {
        return passenger_identity;
    }

    public void setPassengerIdentity(String passengerIdentity) {
        this.passenger_identity = passenger_identity == null ? null : passenger_identity.trim();
    }

    public Integer getPassengerGid() {
        return passenger_gid;
    }

    public void setPassengerGid(Integer passenger_gid) {
        this.passenger_gid = passenger_gid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}