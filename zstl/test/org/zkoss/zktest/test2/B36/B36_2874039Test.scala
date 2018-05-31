/* B36_2874039Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 2874039
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2874039.zul,A,E,Listbox,Borderlayout,BI")
class B36_2874039Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<?page id="indexPage" title="B36-2874039" ?>
<?meta content="text/html; charset=UTF-8" pageEncoding="UTF-8"?>
<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c"?>

<zk xmlns="http://www.zkoss.org/2005/zul" xmlns:h="http://www.w3.org/1999/xhtml"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd">
	<style>body { padding: 0;}</style>
<html><![CDATA[
<ol>
<li>Press the "change" button, and you shall see the title of the right side change from "No Bug" to "Bug".</li>
<li>If you see horizontal scrollbar appear under the listbox, it is a bug. Otherwise, it is OK.</li>
<li>Done</li>
</ol>
]]></html>
	<window id="mainIndexWindow" width="100%" height="100%">

		<borderlayout height="100%">

			<west border="none" margins="0,0,0,0" size="200px" flex="true" minsize="10" splittable="true"
				collapsible="true" autoscroll="false" style="padding: 0px 2px" title="Menu">
				<div>
				<button id="change" label="change">
				<attribute name="onClick">
					mainArea.setTitle("Bug");
				</attribute>
				</button>
				</div>
			</west>
			<center id="mainArea" border="none" margins="0,0,0,0" flex="true" style="padding: 3px;" title="No Bug">
<window>
	<listbox id="listbox" vflex="false" width="100%">
		<listhead sizable="true">
			<listheader label="Col1" width="80px" sort="auto(shortname)" />
			<listheader label="Col2" width="250px" sort="auto(name)" />
			<listheader label="Col3" sort="auto(www)" />
		</listhead>
		<listitem>
			<listcell label="1sdfsd" />
			<listcell label="2fdf" />
			<listcell label="3fsdfs" />
		</listitem>
		<listitem>
			<listcell label="1fsdfsd" />
			<listcell label="2fsdfsd" />
			<listcell label="3fsdfsd" />
		</listitem>
		<listitem>
			<listcell label="1fsdfsd" />
			<listcell label="2fsdfsd" />
			<listcell label="3fsdfsd" />
		</listitem>
		<listitem>
			<listcell label="1fsdfsd" />
			<listcell label="2fsdfsd" />
			<listcell label="3fsdfsd" />
		</listitem>
		<listitem>
			<listcell label="1fsdfsd" />
			<listcell label="2fsdfsd" />
			<listcell label="3fsdfsd" />
		</listitem>
	</listbox>
</window>
			</center>
		</borderlayout>
	</window>
</zk>      """

    runZTL(zscript,
      () => {

        waitResponse();


        //Click change button
        var btn = jq("$change");
        click(btn);
        waitResponse();

        //Check change No Bug to Bug
        var nobug = jq(".z-center-header");
        var bug = getText(nobug);

        verifyEquals(bug, "Bug");

        //Verify Scrollbar
        var lb = zk("$listbox");
        var h = lb.eval("hasHScroll()");
        waitResponse();
        verifyEquals(h, "0");

        var h1 = zk(jq("$listbox").toWidget().$n("body")).eval("hasHScroll()");
        verifyEquals(h1, "0");

      });
  }

}