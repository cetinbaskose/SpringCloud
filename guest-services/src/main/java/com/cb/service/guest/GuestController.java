package com.cb.service.guest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value="/guests")
@Api(value="guests",description = "Data service operations on guests", tags=("guests"))
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get All Guests", notes="Gets all guests in the system", nickname="getGuests")
    public List<Guest> findAll(@RequestParam(name="emailAdress", required = false) String emailAdress){
        if(StringUtils.isNotBlank(emailAdress))
        {
            return Collections.singletonList(this.guestRepository.findByEmailAddress(emailAdress));
        }

        return (List<Guest>) this.guestRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Guest findOne(@PathVariable(name="id") long id){
        return this.guestRepository.findOne(id);
    }

}
