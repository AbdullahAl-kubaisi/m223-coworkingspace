package ch.zli.m223.controller;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;


/**
 * ZLI - M 223
 * @author Al-Kubaisi Abdullah
 * @version 23.11.2022
 * Controller to implement the endpoints
 */



@Path("/booking")
@Tag(name = "Booking", description = "Handling of bookings")
public class BookingController {

    @Inject
    BookingService bookingService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "member"})
    public Booking getBooking(@PathParam("id") Long id) {
        return bookingService.findById(id);
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "member"})
    public Booking createBooking(Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Booking updateBooking(@PathParam("id") Long id, Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"admin", "member"})
    public void deleteBooking(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }
    
}
