/* F60_ZK_613Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 15:20:13 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-613
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-613.zul,F60,A,E,IdSpace,virtual")
class F60_ZK_613Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<html><![CDATA[
				Clicks the following buttons one-by-one. They shall all generate "OK" at
				the end.
				]]></html>
				<separator bar="true"/>
			
				<button id="btnOne" label="test 1">
					<attribute name="onClick"><![CDATA[{
				Div d = new Div();
				Label l = new Label("test");
				l.setId("t1");
				d.appendChild(l);
				if (d.getFellowIfAny("t1") == null)
					alert("t1 not found");
				else if (l.getSpaceOwner() == null || d.getSpaceOwner() == null)
					alert("space owner is wrong: "+l.getSpaceOwner()+":"+d.getSpaceOwner());
				else if (self.getFellowIfAny("t1") != null)
					alert("t1 shall not in page");
				else
					inf.appendChild(new Label("OK"));
					}]]></attribute>
				</button>
			
				<button id="btnTwo" label="test 2">
					<attribute name="onClick"><![CDATA[{
				Div d = new Div();
				inf.appendChild(d);
				Label l = new Label("test");
				l.setId("t2");
				d.appendChild(l);
			
				if (d.getFellowIfAny("t2") == null)
					alert("t2 not found");
				else if (self.getFellowIfAny("t2") == null)
					alert("t2 not found");
				else {
					d.detach();
			
					if (d.getFellowIfAny("t2") == null)
						alert("t2 not found");
					else if (self.getFellowIfAny("t2") != null)
						alert("t2 shall not in page");
					else
						inf.appendChild(new Label("OK"));
				}
					}]]></attribute>
				</button>
			
				<vlayout id="inf"/>
			</zk>

    }

    runZTL(zscript,
        () => {
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");

        click(btnOne);
        waitResponse();
        verifyTrue("Should generate an OK",
            jq(".z-label:contains(OK)").length() == 1);
        click(btnTwo);
        waitResponse();
        verifyTrue("Should generate another OK",
            jq(".z-label:contains(OK)").length() == 2);
    }
   );
  }
}