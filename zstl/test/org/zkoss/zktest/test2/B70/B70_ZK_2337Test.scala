package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase
import scala.util.control.Breaks._

@Tags(tags = "B70-ZK-2337.zul")
class B70_ZK_2337Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2337.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 27, 2014  18:12:12 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	If you don't see the odd row having the odd color style in any of following widgets, that's a bug.
	<hlayout>
		
		<grid width="200px" height="200px">
			<columns>
				<column label="row"/>
			</columns>
			<rows>
				<row><cell>CELL 1</cell></row>
				<row><cell>CELL 2</cell></row>
				<row><cell>CELL 3</cell></row>
				<row><cell>CELL 4</cell></row>
				<row><cell>CELL 5</cell></row>
				<row><cell>CELL 6</cell></row>
			</rows>
		</grid>
		<grid width="200px" height="200px">
			<columns>
				<column label="row"/>
			</columns>
			<rows>
				<row renderdefer="100"><cell>CELL 1</cell></row>
				<row renderdefer="200"><cell>CELL 2</cell></row>
				<row renderdefer="300"><cell>CELL 3</cell></row>
				<row renderdefer="400"><cell>CELL 4</cell></row>
				<row renderdefer="500"><cell>CELL 5</cell></row>
				<row renderdefer="600"><cell>CELL 6</cell></row>
			</rows>
		</grid>
	    <zscript><![CDATA[
	        String[] data = new String[300];
	        for(int j=0; j < data.length; ++j) {
	            data[j] = "option "+j;
	        }
	        ListModel strset = new SimpleListModel(data);
	        ]]></zscript>
	    <grid height="200px" width="200px" model="${strset}">
	        <columns>
	            <column label="options"/>
	        </columns>
	    </grid>
		<grid height="200px" width="200px" model="${strset}">
	    	<custom-attributes org.zkoss.zul.grid.rod="false"/>
	        <columns>
	            <column label="options"/>
	        </columns>
	        <rows renderdefer="1000">
	        	<template name="model">
		        	<row>${each}</row>
	        	</template>
	        </rows>
	    </grid>
	</hlayout>
	
	<hlayout>
		<listbox width="200px" height="250px">
	        <listhead sizable="true">
	            <listheader label="name" sort="auto" />
	            <listheader label="gender" sort="auto" />
	        </listhead>
	        <listitem>
	            <listcell label="Mary" />
	            <listcell label="FEMALE" />
	        </listitem>
	        <listitem>
	            <listcell label="John" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem>
	            <listcell label="Jane" />
	            <listcell label="FEMALE" />
	        </listitem>
	        <listitem>
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem>
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem>
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem>
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
		</listbox>
		<listbox width="200px" height="250px">
	        <listhead sizable="true">
	            <listheader label="name" sort="auto" />
	            <listheader label="gender" sort="auto" />
	        </listhead>
	        <listitem renderdefer="100">
	            <listcell label="Mary" />
	            <listcell label="FEMALE" />
	        </listitem>
	        <listitem renderdefer="200">
	            <listcell label="John" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem renderdefer="300">
	            <listcell label="Jane" />
	            <listcell label="FEMALE" />
	        </listitem>
	        <listitem renderdefer="400">
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem renderdefer="500">
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem renderdefer="600">
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
	        <listitem renderdefer="700">
	            <listcell label="Henry" />
	            <listcell label="MALE" />
	        </listitem>
		</listbox>
		
		<zscript><![CDATA[
			String[] data = new String[300];
			for (int j = 0; j < data.length; ++j) {
				data[j] = "option " + j;
			}
			ListModel strset = new SimpleListModel(data);
		]]></zscript>
		<listbox width="200px" height="250px" model="${strset}">
			<listhead>
				<listheader label="Load on demend" />
			</listhead>
		</listbox>
		<listbox width="200px" height="250px" model="${strset}">
			<custom-attributes org.zkoss.zul.listbox.rod="false"/>
			<listhead>
				<listheader label="Load on demend" />
			</listhead>
			<template name="model">
				<listitem renderdefer="1000">
					<listcell>${each}</listcell>
				</listitem>
			</template>
		</listbox>
	</hlayout>
</zk>

"""  
  runZTL(zscript,
    () => {
    	sleep(2000);
        var iter = jq("@listbox").iterator();
        while (iter.hasNext()) {
          val itemIter = iter.next().find("@listitem").iterator();
          var odd = false;
          breakable {
            while (itemIter.hasNext()) {
              if (itemIter.next().hasClass("z-listbox-odd")) {
                odd = true;
                break;
              }
            }
          }
          verifyTrue("threre are no odd color style in listbox", odd);
        }

        iter = jq("@grid").iterator();
        while (iter.hasNext()) {
          val itemIter = iter.next().find("@row").iterator();
          var odd = false;
          breakable {
            while (itemIter.hasNext()) {
              if (itemIter.next().hasClass("z-grid-odd")) {
                odd = true;
                break;
              }
            }
          }
          verifyTrue("threre are no odd color style in grid", odd);

        }
    })
    
  }
}