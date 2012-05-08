/**
 * 
 */
package ie.cit.cloudapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ie.cit.cloudapp.Trip;
import ie.cit.cloudapp.UserInfo;
import ie.cit.cloudapp.calculateDays;
import ie.cit.cloudapp.currentUser;
import ie.cit.cloudapp.jdbcTripRepository;
import ie.cit.cloudapp.jdbcUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fiona
 * 
 */

@Controller
@RequestMapping("/travel/tracker/traveltracker")
public class TravelController {
	@Autowired
	private jdbcUserRepository userrepo;
	@Autowired
	private jdbcTripRepository triprepo;
    public currentUser currentusr = new currentUser();
   
	
	@RequestMapping(method = RequestMethod.GET)
	public void getTravelTracker(Model model) {	
		currentusr.setCurrentUser(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("trips", triprepo.getAllTrips(currentusr.getCurrentUser()));
		model.addAttribute("user", userrepo.getUserData(currentusr.getCurrentUser()));
		
		
		
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public void addTripData(Model model, @RequestParam String strdeptdate,
			@RequestParam String strexitdate, @RequestParam String departure,
			@RequestParam String destination, @RequestParam String route ) throws ParseException {
		Trip trip = new Trip();
		Boolean existingtrip = false;
		calculateDays calcdays = new calculateDays();
		Date deptdate =calcdays.StrToDate(strdeptdate); 
		Date exitdate =calcdays.StrToDate(strexitdate);
	
		
		if (! triprepo.getDeptDate(destination, currentusr.getCurrentUser(), strdeptdate).isEmpty())
			// just display stored trips for this user
		{
			existingtrip=true;
			model.addAttribute("existingtrip",existingtrip);
			}
		else {
			trip.setDeptdate(strdeptdate); // this is stored as a String
			trip.setExitdate(strexitdate); // this is stored as a String
			trip.setDeparture(departure);
			trip.setDestination(destination);
			trip.setRoute(route);
			trip.setUsername(currentusr.getCurrentUser());
			//calculate days and store with trip data
		    trip.setDays((int) calcdays.daysBetween(calcdays.DateToCalendar(deptdate),calcdays.DateToCalendar(exitdate)));
	        // save to the database
		    triprepo.save(trip);
		}

		model.addAttribute("trips", triprepo.getAllTrips(currentusr.getCurrentUser()));
		model.addAttribute("user", userrepo.getUserData(currentusr.getCurrentUser()));
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteTrip(Model model, @RequestParam int tripId) {
		triprepo.delete(tripId);
		model.addAttribute("trips", triprepo.getAllTrips(currentusr.getCurrentUser()));
		model.addAttribute("user", userrepo.getUserData(currentusr.getCurrentUser()));
	
	}


}
