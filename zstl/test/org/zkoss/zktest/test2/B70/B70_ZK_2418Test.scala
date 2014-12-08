package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2418.zul")
class B70_ZK_2418Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
<zk>
	<style>
		.z-listcell { width: 200px !important; } .z-listheader{ width: 200px !important;

		} 
		.z-listbox-body{ height : 300px; overflow:scroll; }
	</style>
	issue under 7.0.1
	ZK-2189
	ZK-2194
	ZK-2193
	
	<label multiline="true">
		1. move scroll bar to rightmost position
		2. select 1st item
		3. press down arrow key
		The Horizontal scroll bar should not move
	
	</label>
	<listbox id="box">
		<listhead>
			<listheader label="Name" />
			<listheader label="Gender" />
			<listheader label="Age" />
			<listheader label="Description" />
			<listheader label="Name" />
			<listheader label="Gender" />
			<listheader label="Age" />
			<listheader label="Description" />
			<listheader label="Name" />
			<listheader label="Gender" />
			<listheader label="Age" />
			<listheader label="Description" />
			<listheader label="Name" />
			<listheader label="Gender" />
			<listheader label="Age" />
			<listheader label="Description" />
			<listheader label="Name" />
			<listheader label="Gender" />
			<listheader label="Age" />
			<listheader label="Description" />
			<listheader label="Name" />
			<listheader label="Gender" />
			<listheader label="Age" />
			<listheader label="Description" />
		</listhead>
		<listitem>
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
		</listitem>
		<listitem>
			<listcell label="John" />
			<listcell label="MALE" />
			<listcell label="20" />
			<listcell label="A college student." />
			<listcell label="John" />
			<listcell label="MALE" />
			<listcell label="20" />
			<listcell label="A college student." />
			<listcell label="John" />
			<listcell label="MALE" />
			<listcell label="20" />
			<listcell label="A college student." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
		</listitem>
		<listitem>
			<listcell label="Jane" />
			<listcell label="FEMALE" />
			<listcell label="32" />
			<listcell label="A remarkable artist." />
			<listcell label="Jane" />
			<listcell label="FEMALE" />
			<listcell label="32" />
			<listcell label="A remarkable artist." />
			<listcell label="Jane" />
			<listcell label="FEMALE" />
			<listcell label="32" />
			<listcell label="A remarkable artist." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
		</listitem>
		<listitem>
			<listcell label="Henry" />
			<listcell label="MALE" />
			<listcell label="29" />
			<listcell label="A graduate." />
			<listcell label="Henry" />
			<listcell label="MALE" />
			<listcell label="29" />
			<listcell label="A graduate." />
			<listcell label="Henry" />
			<listcell label="MALE" />
			<listcell label="29" />
			<listcell label="A graduate." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
		</listitem>
		<listitem>
			<listcell label="Henry" />
			<listcell label="MALE" />
			<listcell label="29" />
			<listcell label="A graduate." />
			<listcell label="Henry" />
			<listcell label="MALE" />
			<listcell label="29" />
			<listcell label="A graduate." />
			<listcell label="Henry" />
			<listcell label="MALE" />
			<listcell label="29" />
			<listcell label="A graduate." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
			<listcell label="A young lady." />
		</listitem>
	</listbox>
	<custom-attributes org.zkoss.zul.nativebar="false"/>
</zk>

"""  
  runZTL(zscript,
    () => {
      
      val listbox = jq("@listbox").toWidget();
      val firstitem = jq(".z-listitem").first().children().last();
      val a = listbox.$n("a"); //button can be focused and sendKey
      
      mouseOver(listbox.$n("hor-embed"));
      waitResponse();
      horScroll(listbox.$n("hor"), 1);
      waitResponse();
      click(firstitem);
      focus(a);
      sendKeys(a, Keys.DOWN);
      waitResponse();
      verifyTrue(jq(listbox.$n("hor-embed")).positionLeft() != 0);
        
    })
    
  }
}