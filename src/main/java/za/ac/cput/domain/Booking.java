package za.ac.cput.domain;

public class Booking {

    private String bookingId;
    private String bookingDate;
    private String startDate;
    private String endDate;
    private BookingStatus bookingStatus;

    private Booking() {
    }

    private Booking(Booking.Builder builder) {
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.bookingStatus = builder.bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", bookingStatus=" + bookingStatus +
                '}';
    }

    public static class Builder {
        private String bookingId;
        private String bookingDate;
        private String startDate;
        private String endDate;
        private BookingStatus bookingStatus;

        public Booking.Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Booking.Builder setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Booking.Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Booking.Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Booking.Builder setBookingStatus(BookingStatus bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}

