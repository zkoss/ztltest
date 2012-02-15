/* B50_ZK_837Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Feb 15 15:45:36 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

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
 * A test class for bug ZK-837
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-837.zul,A,M,Datebox")
class B50_ZK_837Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
    			<window>
    				<zscript>
  	    				org.zkoss.zktest.test2.ZK837BasicConstraint constraint = new org.zkoss.zktest.test2.ZK837BasicConstraint("no empty");
    				</zscript>
    				<div>Enter an invalid date, e.g. 92.02.2012</div>
    				<hlayout>
    					<datebox id="dbxOne" constraint="${constraint}" timeZone="org.zkoss.util.TimeZones.getCurrent()"/>
			          
			           <datebox id="dbxTwo" timeZone="org.zkoss.util.TimeZones.getCurrent()"/>
    					<label id="lb" value="click area" />
    				</hlayout>
    			</window>
    		</zk>

    }

   runZTL(zscript,
        () => {
        var dbxOne: Widget = engine.$f("dbxOne");
        var dbxTwo: Widget = engine.$f("dbxTwo");
        var lb: Widget = engine.$f("lb");
        def inputAndVerify (dbx: Widget) {
        	focus(dbx.$n("real"));
        	sendKeys(dbx.$n("real"), "92.02.2012");
        	click(lb);
        	waitResponse();
        	verifyFalse("should no exception",
        			jq(".z-window-modal").exists());
        }
        inputAndVerify(dbxOne);
        inputAndVerify(dbxTwo);
    }
   );
  }
}