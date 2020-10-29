package pers.lagomoro.railway_system.entity.unused;

public class Ticket {
    private Integer ticketId;

    private Integer oid;

    private Integer seatId;

    private Integer journey;

    private String passengerName;

    private String passengerIdentity;

    private Integer passengerGid;

    private Integer status;

    public Ticket(Integer ticketId, Integer oid, Integer seatId, Integer journey, String passengerName, String passengerIdentity, Integer passengerGid, Integer status) {
        this.ticketId = ticketId;
        this.oid = oid;
        this.seatId = seatId;
        this.journey = journey;
        this.passengerName = passengerName;
        this.passengerIdentity = passengerIdentity;
        this.passengerGid = passengerGid;
        this.status = status;
    }

    public Ticket() {
        super();
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getJourney() {
        return journey;
    }

    public void setJourney(Integer journey) {
        this.journey = journey;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName == null ? null : passengerName.trim();
    }

    public String getPassengerIdentity() {
        return passengerIdentity;
    }

    public void setPassengerIdentity(String passengerIdentity) {
        this.passengerIdentity = passengerIdentity == null ? null : passengerIdentity.trim();
    }

    public Integer getPassengerGid() {
        return passengerGid;
    }

    public void setPassengerGid(Integer passengerGid) {
        this.passengerGid = passengerGid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}