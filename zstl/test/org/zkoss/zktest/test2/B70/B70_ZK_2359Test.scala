package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.unit.JQuery

@Tags(tags = "B70-ZK-2359.zul")
class B70_ZK_2359Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2359.zul

	Purpose:
		
	Description:
		
	History:
		Thur, Jul 17, 2014  8:53:06 AM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript><![CDATA[
	    //org.zkoss.lang.Library.setProperty("org.zkoss.theme.preferred", "sapphire");
	]]></zscript>
	<div>
		1. when you see the paging flickering after change page to #3 in listbox, that's a bug.
		<separator/>
		2. also make sure all rows are the same height, default value is 30 pixel for class z-listcell-content, z-row-content, z-group-content, z-groupfoot-content, z-treecell-content. 
	</div>
	<listbox id="lstResults" context="resultGridContextMenu" 
		mold="paging" height="300px" width="400px" autopaging="true"
		multiple="true">
		<listhead id="lstHead" sizable="true">
			<listheader id="COL_1" width="200px"
				label="Column 1" />
			<listheader id="COL_2" width="275px"
				label="Column 2" />
		</listhead>
	</listbox>
	
	<grid mold="paging" height="300px" width="400px" autopaging="true">
		<columns sizable="true">
            <column label="Type" width="200px"/>
            <column label="Content" width="275px"/>
        </columns>
        <rows id="row">
        	<group label="aaa"/>
        	<groupfoot>
                <label value="This a summary about Compaq Desktop PCs"/>
            </groupfoot>
        </rows>
	</grid>
	
	<tree id="tree" mold="paging" height="300px" width="400px" autopaging="true">
        <treecols sizable="true">
            <treecol label="Name" />
            <treecol label="Description" />
        </treecols>
        <treechildren>
            <treeitem>
                <treerow>
                    <treecell label="Item 1" />
                    <treecell label="Item 1 description" />
                </treerow>
            </treeitem>
            <treeitem>
                <treerow>
                    <treecell label="Item 2" />
                    <treecell label="Item 2 descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription" />
                </treerow>
                <treechildren>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.1" />
                        </treerow>
                    </treeitem>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.2" />
                            <treecell
                                label="Item 2.2 is somethidescriptiondescriptiondescriptiondescriptiondescriptionng who cares" />
                        </treerow>
                    </treeitem>
                </treechildren>
            </treeitem>
            <treeitem label="Item 3" />
             <treeitem>
                <treerow>
                    <treecell label="Item descriptiondescriptiondescriptiondescriptiondescription1descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription" />
                    <treecell label="Item 1 desdescriptioncription" />
                </treerow>
            </treeitem>
            <treeitem>
                <treerow>
                    <treecell label="Item 2" />
                    <treecell label="Item 2 description" />
                </treerow>
                <treechildren>
                    <treeitem>
                        <treerow>
                            <treecell label="Itedescriptiondescriptiondescriptiondescriptiondescriptionm 2.1" />
                        </treerow>
                    </treeitem>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.2" />
                            <treecell
                                label="Item 2.2 is something who cares" />
                        </treerow>
                    </treeitem>
                </treechildren>
            </treeitem>
            <treeitem label="Item 3" />
             <treeitem>
                <treerow>
                    <treecell label="Item 1" />
                    <treecell label="Item 1 description" />
                </treerow>
            </treeitem>
            <treeitem>
                <treerow>
                    <treecell label="Item 2" />
                    <treecell label="Item 2 description" />
                </treerow>
                <treechildren>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.1" />
                        </treerow>
                    </treeitem>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.2" />
                            <treecell
                                label="Item 2.2 is something who cares" />
                        </treerow>
                    </treeitem>
                </treechildren>
            </treeitem>
            <treeitem label="Item 3" />
                        <treeitem>
                <treerow>
                    <treecell label="Item 2" />
                    <treecell label="Item 2 description" />
                </treerow>
                <treechildren>
                    <treeitem>
                        <treerow>
                            <treecell label="Itedescriptiondescriptiondescriptiondescriptiondescriptionm 2.1" />
                        </treerow>
                    </treeitem>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.2" />
                            <treecell
                                label="Item 2.2 is something who cares" />
                        </treerow>
                    </treeitem>
                </treechildren>
            </treeitem>
            <treeitem label="Item 3" />
             <treeitem>
                <treerow>
                    <treecell label="Item 1" />
                    <treecell label="Item 1 description" />
                </treerow>
            </treeitem>
            <treeitem>
                <treerow>
                    <treecell label="Item 2" />
                    <treecell label="Item 2 description" />
                </treerow>
                <treechildren>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.1" />
                        </treerow>
                    </treeitem>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.2" />
                            <treecell
                                label="Item 2.2 is something who cares" />
                        </treerow>
                    </treeitem>
                </treechildren>
            </treeitem>
            <treeitem label="Item 3" />
        </treechildren>
        <treefoot>
            <treefooter label="Count" />
            <treefooter label="Summary" />
        </treefoot>
    </tree>
	
	<zscript><![CDATA[
		for(int i = 0; i < 200; i++){
			Listitem item = new Listitem();
			String c1 = "", c2 = "";
			for(int j = 0; j < i - 10; j++) {
				c1 += "test-left" + j;
				c2 += "test-right" + j;
			}
				
			item.appendChild(new Listcell(c1));
			item.appendChild(new Listcell(c2));
			lstResults.appendChild(item);
		}
		
		for(int i = 0; i < 20; i++){
			Row r = new Row();
			String c1 = "", c2 = "";
			for(int j = 0; j < i - 10; j++) {
				c1 += "test-left" + j;
				c2 += "test-right" + j;
			}
			
			r.appendChild(new Label(c1));
			r.appendChild(new Label(c2));
				
			row.appendChild(r);
		}
	]]></zscript>
</zk>

"""
    runZTL(zscript,
      () => {
        var check = (input: JQuery) => {
          val value = input.attr("value");
          for (_ <- 1 to 5) {
            sleep(300);
            verifyTrue("value should be the same. it means no flickering.", input.attr("value").equals(value));
          }
        };

        var btn = jq("@listbox").find(".z-paging-button").eq(2);
        clickAt(btn, "1,1");
        waitResponse();
        clickAt(btn, "1,1");
        waitResponse();
        clickAt(btn, "1,1");
        waitResponse();
        check(jq("@listbox").find(".z-paging-input"));

        btn = jq("@grid").find(".z-paging-button").eq(2);
        clickAt(btn, "1,1");
        waitResponse();
        clickAt(btn, "1,1");
        waitResponse();
        clickAt(btn, "1,1");
        waitResponse();
        check(jq("@grid").find(".z-paging-input"));

        btn = jq("@tree").find(".z-paging-button").eq(2);
        clickAt(btn, "1,1");
        waitResponse();
        clickAt(btn, "1,1");
        waitResponse();
        clickAt(btn, "1,1");
        waitResponse();
        check(jq("@tree").find(".z-paging-input"));
      })

  }
}