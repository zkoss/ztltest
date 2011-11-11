/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.zbind.basic

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_CommandIndirectTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {//command-indirect.zul
<window apply="org.zkoss.zktest.zbind.basic.CommandIndirectComposer">
	<custom-attributes composerName="vm"/>
	<vbox>
	<label id="commandLabel" value="@bind(vm.value1)"/>
	<checkbox id="commandBox" label="another command" checked="@bind(vm.checked)" />
	</vbox>
	
	<hbox>
		<button id="commandButton" label="Cmd" onClick="@bind(vm.checked?'command1':'command2')" />
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>	
</window>
    }
    runZTL(zul, () => {
    	val commandLabel = engine $f "commandLabel"
    	val commandBox = engine $f "commandBox"
    	val commandButton = engine $f "commandButton"
    	
    	ZKSeleneseTestCase.assertEquals("no-command", getText(commandLabel));
    	click(commandButton);
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("by command1", getText(commandLabel));
    	
    	click(commandBox.$n("real"))
    	click(commandButton);
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("by command2", getText(commandLabel));

    })
  }
}
