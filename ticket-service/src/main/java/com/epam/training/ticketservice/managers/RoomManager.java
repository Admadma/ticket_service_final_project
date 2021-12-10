package com.epam.training.ticketservice.managers;

import com.epam.training.ticketservice.services.rooms.RoomServiceImpl;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class RoomManager {

    private final RoomServiceImpl roomServiceImpl;
    private final UserManager userManager;

    public RoomManager(RoomServiceImpl roomServiceImpl, UserManager userManager) {
        this.roomServiceImpl = roomServiceImpl;
        this.userManager = userManager;
    }

    @ShellMethod(key="create room", value="Allow admin to create given room")
    public void createRoom(String roomName, int rows, int cols){
        if(userManager.isAdminUser())
            roomServiceImpl.addRoom(roomName, rows, cols);
    }

    @ShellMethod(key="update room", value="Allow admin to update given room")
    public void updateRoom(String roomName, int rows, int cols){
        if(userManager.isAdminUser())
            roomServiceImpl.updateRoom(roomName, rows, cols);
    }

    @ShellMethod(key="delete room", value="Allow admin to delete given room")
    public void deleteRoom(String roomName){
        if(userManager.isAdminUser())
            roomServiceImpl.deleteRoom(roomName);
    }

    @ShellMethod(key="list rooms", value="Allow anyone to list rooms")
    public void listRooms(){
        roomServiceImpl.listRooms();
    }
}
