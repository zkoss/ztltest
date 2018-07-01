/* F60_ZK_523Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 14:42:11 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-523
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-523.zul,F60,B,E,Columnlayout")
class F60_ZK_523Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>This page should displaied without any problem.</div>
			    <style>
			        .pointer {
			            cursor: pointer;
			        }
			    </style>
			    <div width="600px" height="400px">
				    <columnlayout>
				        <columnchildren width="50%">
				            <listbox id="left" multiple="true" height="300px"
				                oddRowSclass="non-odd" fixedLayout="true" checkmark="true">
				                <listitem selected="true">
				                    <listcell label="ZK Forge"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				                <listitem>
				                    <listcell label="ZK Mobile"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				                <listitem>
				                    <listcell label="ZK GWT"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				                <listitem>
				                    <listcell label="ZK JSF"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				                <listitem>
				                    <listcell label="ZK JSP"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				            </listbox>
				        </columnchildren>
				        <columnchildren width="100px">
				        	<div style="margin: 70px 34px;">
					            <image sclass="pointer" tooltiptext="Add Project"
					                src="/img/Centigrade-Widget-Icons/ButtonArrowRightDouble-32x32.png">
					                <attribute name="onClick"><![CDATA[
					                    Set items = left.getSelectedItems();
					                    if (items.isEmpty()) {
					                        alert("Please select at least one project to add!");
					                    } else {
					                        List al = new ArrayList(items);
					                        for (Iterator it = al.iterator(); it.hasNext();) {
					                            Listitem li = (Listitem)it.next();
					                            li.setSelected(false);
					                            right.appendChild(li);
					                        }
					                    }
					                ]]></attribute>
					            </image>
					            <separator height="15px"/>
					            <image sclass="pointer" tooltiptext="Remove Project"
					                src="/img/Centigrade-Widget-Icons/ButtonArrowLeftDouble-32x32.png">
					                <attribute name="onClick"><![CDATA[
					                    Set items = right.getSelectedItems();
					                    if (items.isEmpty()) {
					                        alert("Please select at least one project to remove!");
					                    } else {
					                        List al = new ArrayList(items);
					                        for (Iterator it = al.iterator(); it.hasNext();) {
					                            Listitem li = (Listitem)it.next();
					                            li.setSelected(false);
					                            left.appendChild(li);
					                        }
					                    }
					                ]]></attribute>
					            </image>
					        </div>
				        </columnchildren>
				        <columnchildren width="50%">
				            <listbox id="right" multiple="true" height="300px"
				                oddRowSclass="non-odd" fixedLayout="true" checkmark="true">
				                <listitem>
				                    <listcell label="ZK"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				                <listitem>
				                    <listcell label="ZK Studio"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				                <listitem>
				                    <listcell label="ZK Spring"
				                        src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" />
				                </listitem>
				            </listbox>  
				        </columnchildren>
				    </columnlayout>
				</div>
			</zk>

    """

    runZTL(zscript,
      () => {
        verifyTrue("The listbox should displayed well",
          jq(".z-listbox:contains(ZK Spring)").exists());
      }
    );
  }
}