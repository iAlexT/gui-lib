GUI Lib
-------------

This library make you able to create simple menus easy

---------
Here is an example:
```java
    public WindowBuilder createMenu(Player who) {
        return WindowBuilder
                .newBuilder("Title", 3)
                .addItem(
                        WindowItem
                        .newBuilder(
                                10,
                                ItemBuilder
                                .newBuilder(
                                        Material.BED
                                )
                                .name("Name")
                                .lore(Arrays.asList(
                                        "Line 1", "Line 2", "Line 3"
                                ))
                                .build(),
                                click -> {
                                    who.sendMessage("You've clicked an item!");
                                    
                                    return true;
                                }
                        )
                )
                .openEvent(event -> {
                    who.sendMessage("You're opening a menu!");
                    
                    return false;
                })
                .closeEvent(event -> {
                    who.sendMessage("You're closing a menu!");
                    
                    return false;
                });
    } 
```