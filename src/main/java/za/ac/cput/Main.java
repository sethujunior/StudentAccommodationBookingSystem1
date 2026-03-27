package za.ac.cput;

import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  Student Accommodation Booking System  ");
        System.out.println("========================================\n");

        // -------------------------------------------------------
        // 1. ROOM TYPE
        // -------------------------------------------------------
        System.out.println("--- Room Type ---");
        RoomType roomType = RoomTypeFactory.createRoomType(
                "RT-001",
                8.0,
                4.5,
                3.0,
                4.0,
                3500.00
        );
        System.out.println("Created: " + roomType);

        IRoomTypeRepository roomTypeRepo = RoomTypeRepository.getInstance();
        roomTypeRepo.create(roomType);

        RoomType foundRoomType = roomTypeRepo.read("RT-001");
        System.out.println("Read:    " + foundRoomType);

        RoomType updatedRoomType = new RoomType.Builder()
                .copy(roomType)
                .setCapacity(5.0)
                .setPrice(4000.00)
                .build();
        roomTypeRepo.update(updatedRoomType);
        System.out.println("Updated: " + roomTypeRepo.read("RT-001"));
        System.out.println("All Room Types: " + roomTypeRepo.getAllRoomTypes());
        System.out.println();

        // -------------------------------------------------------
        // 2. ROOM
        // -------------------------------------------------------
        System.out.println("--- Room ---");
        Room room = RoomFactory.createRoom(
                "R-101",
                "1",
                "A101",
                5400.00,
                RoomStatus.AVAILABLE
        );
        System.out.println("Created: " + room);

        IRoomRepository roomRepo = RoomRepository.getInstance();
        roomRepo.create(room);

        Room foundRoom = roomRepo.read("R-101");
        System.out.println("Read:    " + foundRoom);

        Room updatedRoom = new Room.Builder()
                .copy(room)
                .setRoomStatus(RoomStatus.OCCUPIED)
                .build();
        roomRepo.update(updatedRoom);
        System.out.println("Updated: " + roomRepo.read("R-101"));
        System.out.println("All Rooms: " + roomRepo.getAllRooms());
        System.out.println();

        // -------------------------------------------------------
        // 3. STUDENT
        // -------------------------------------------------------
        System.out.println("--- Student ---");
        ContactDetails contactDetails = new ContactDetails.Builder()
                .setStudentEmail("john.doe@student.cput.ac.za")
                .setPhone("0721234567")
                .build();

        Address address = new Address.Builder()
                .setStreet("15 Main Road")
                .setCity("Cape Town")
                .setPostalCode("8001")
                .build();

        Student student = StudentFactory.createStudent(
                "230123456",
                "John Doe",
                GenderType.MALE,
                address,
                contactDetails
        );
        System.out.println("Created: " + student);

        IStudentRepository studentRepo = StudentRepository.getInstance();
        studentRepo.create(student);

        Student foundStudent = studentRepo.read("230123456");
        System.out.println("Read:    " + foundStudent);
        System.out.println("All Students: " + studentRepo.getAll());
        System.out.println();

        // -------------------------------------------------------
        // 4. ACCOMMODATION
        // -------------------------------------------------------
        System.out.println("--- Accommodation ---");
        Address accomAddress = new Address.Builder()
                .setStreet("99 Buitenkant Street")
                .setCity("Cape Town")
                .setPostalCode("8001")
                .build();

        Accomodation accommodation = AccomodationFactory.createAccomodation(
                "ACC-001",
                "CPUT Residence A",
                GenderType.MALE,
                "0219876543",
                accomAddress,
                AccomodationStatus.AVAILABLE
        );
        System.out.println("Created: " + accommodation);

        IAccomodationRepository accomRepo = AccomodationRepository.getRepository();
        accomRepo.create(accommodation);

        Accomodation foundAccom = accomRepo.read("ACC-001");
        System.out.println("Read:    " + foundAccom);

        Accomodation updatedAccom = new Accomodation.Builder()
                .copy(accommodation)
                .setAccomodationStatus(AccomodationStatus.OCCUPIED)
                .build();
        accomRepo.update(updatedAccom);
        System.out.println("Updated: " + accomRepo.read("ACC-001"));
        System.out.println();

        // -------------------------------------------------------
        // 5. BOOKING
        // -------------------------------------------------------
        System.out.println("--- Booking ---");
        Booking booking = BookingFactory.createBooking(
                "B-001",
                "2026-03-27",
                "2026-04-01",
                "2026-10-31",
                BookingStatus.CONFIRMED
        );
        System.out.println("Created: " + booking);

        IBookingRepository bookingRepo = BookingRepositoryImpl.getRepository();
        bookingRepo.create(booking);

        Booking foundBooking = bookingRepo.read("B-001");
        System.out.println("Read:    " + foundBooking);

        Booking updatedBooking = new Booking.Builder()
                .copy(booking)
                .setBookingStatus(BookingStatus.COMPLETED)
                .build();
        bookingRepo.update(updatedBooking);
        System.out.println("Updated: " + bookingRepo.read("B-001"));
        System.out.println("All Bookings: " + bookingRepo.getAll());
        System.out.println();

        // -------------------------------------------------------
        // 6. INVOICE LINE
        // -------------------------------------------------------
        System.out.println("--- Invoice Line ---");
        InvoiceLine invoiceLine = InvoiceLineFactory.createInvoiceLine(
                "Monthly Room Rental - April 2026",
                1,
                5400.00
        );
        System.out.println("Created: " + invoiceLine);

        IInvoiceLineRepository invoiceLineRepo = InvoiceLineRepository.getInstance();
        invoiceLineRepo.create(invoiceLine);
        System.out.println("All Invoice Lines: " + invoiceLineRepo.getAll());
        System.out.println();

        // -------------------------------------------------------
        // 7. INVOICE
        // -------------------------------------------------------
        System.out.println("--- Invoice ---");
        Invoice invoice = InvoiceFactory.createInvoice(
                LocalDate.now(),
                "John Doe - 230123456",
                5400.00
        );
        System.out.println("Created: " + invoice);

        IInvoiceRepository invoiceRepo = InvoiceRepository.getInstance();
        invoiceRepo.create(invoice);

        Invoice foundInvoice = invoiceRepo.read(invoice.getInvoiceId());
        System.out.println("Read:    " + foundInvoice);

        Invoice updatedInvoice = new Invoice.Builder()
                .copy(invoice)
                .setTotalAmount(6000.00)
                .build();
        invoiceRepo.update(updatedInvoice);
        System.out.println("Updated: " + invoiceRepo.read(invoice.getInvoiceId()));
        System.out.println("All Invoices: " + invoiceRepo.getAll());
        System.out.println();

        System.out.println("========================================");
        System.out.println("           System Demo Complete         ");
        System.out.println("========================================");
    }
}