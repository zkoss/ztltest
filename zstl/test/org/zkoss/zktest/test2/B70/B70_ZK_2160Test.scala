package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2306.zul")
class B70_ZK_2160Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2160.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Apr 16, 2014  3:28:21 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  
  <div> 

    <hbox>
 
      <label multiline="true">
      1. Shorten the borwser's height, make the menupopup open at left side by clicking the "Click Me" button.
      2. Don't move the cursor, wait 2 seconds. The menupopup should not change its position.
      </label>
                
    
   
    <menubar id="menubar">
                <menu label="Click me">
                    <menupopup>
                        <menu label="Mouseover me">
                            <menupopup>
                               <menu label="And mouseover me">
                                   <menupopup>
                                       <menuitem label="Wait a moment"/>
                                       <menuitem label="for timer to fire"/>
                                       <menuitem label="and menu jumps"/>
                                    </menupopup>
                                </menu>
                            </menupopup>
                        </menu>
                      
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                         <menu label="Try again here">
                            <menupopup>
                               <menu label="And mouseover me">
                                   <menupopup>
                                       <menuitem label="Wait a moment"/>
                                       <menuitem label="for timer to fire"/>
                                       <menuitem label="and menu jumps"/>
                                    </menupopup>
                                </menu>
                            </menupopup>
                        </menu>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                        <menuitem label="filler"/>
                    </menupopup>
                </menu>
       

            </menubar>
      </hbox>
   
    <!-- refresh content every 5 seconds -->
    <timer id="timer" delay="2000" repeats="true" onTimer=""/>
    
  </div>
</zk>
"""
    runZTL(zscript,
      () => {
        
        val menu = jq("@menu:visible");
        click(menu);
        waitResponse();
        
        val popup = jq("@menupopup:visible");
        val rightOffset = popup.width() + popup.offsetLeft();
        println(rightOffset + "," + menu.offsetLeft());
        verifyTrue("Menu popup should be at the left side of menu.", rightOffset < menu.offsetLeft());
        sleep(2500);
        
        verifyTrue("Menu popup should be at the same position after blocking 2 seconds.", rightOffset == popup.width() + popup.offsetLeft());
      })

  }
}