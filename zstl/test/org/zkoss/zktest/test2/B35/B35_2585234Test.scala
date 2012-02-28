/* B35_2585234Test.scala

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
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 2585234
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2585234.zul,A,E,Paging,Group,Grid")
class B35_2585234Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2585234.zul

	Purpose:
		
	Description:
		
	History:
		Thu Feb 19 18:21:45     2009, Created by jumperchen

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript>
	import org.zkoss.zktest.util.*;
	LiveGroupRenderer renderer = new LiveGroupRenderer();
	</zscript>
	
	<zscript>
		String[][][] datas = new String[][][]{
			new String[][] {
				// Today
				new String[]{"1","[zk1 - Help] RE: Bandbox Autocomplete Problem","2008/11/18 10:16:27","16KB"},
				new String[]{"2","[zk1 - Help] RE: Bandbox Autocomplete Problem","2008/11/18 10:14:27","18KB"},
				new String[]{"3","[zk1 - Help] RE: Databinding with radiogroups","2008/11/18 09:47:27","12KB"},
				new String[]{"4","[zk1 - Help] RE: It's not possible to navigate a listbox' ite","2008/11/18 09:35:27","12KB"},
				new String[]{"5","[zk1 - Help] RE: ZK problem in dynamic menu","2008/11/18 08:37:27","12KB"},				
				new String[]{"6","[zk1 - Help] RE: FileUpload","2008/11/18 08:27:57","14KB"},
				new String[]{"7","[zk1 - Help] RE: Datebox format","2008/11/18 06:27:31","11KB"},
				new String[]{"8","[zk1 - Help] RE: Datebox format","2008/11/18 06:17:22","12KB"},
				new String[]{"9","[zk1 - Help] FileUpload","2008/11/18 05:07:25","11KB"},
				new String[]{"10","[zk1 - Help] FileUpload","2008/11/18 05:07:25","11KB"},
				new String[]{"11","[zk1 - Help] FileUpload","2008/11/18 05:07:25","11KB"},
				new String[]{"12","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"13","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"14","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"15","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"16","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/18 04:31:12","14KB"},
			},
			new String[][] {
				// Yesterday
				new String[]{"1","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 19:44:17","39KB"},
				new String[]{"2","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 19:42:17","35KB"},
				new String[]{"3","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 19:40:17","26KB"},
				new String[]{"4","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 18:14:17","27KB"},
				new String[]{"5","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 17:05:17","18KB"},
				new String[]{"6","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 16:44:17","19KB"},
				new String[]{"7","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"8","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"9","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"10","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"11","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 13:26:37","14KB"},
				new String[]{"12","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 13:26:37","14KB"},
				new String[]{"13","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 13:26:37","14KB"},
				new String[]{"14","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 10:41:33","14KB"},	
				new String[]{"15","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 10:14:27","14KB"},
			},
			new String[][] {
				new String[]{"1","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/15 04:31:12","14KB"},
				new String[]{"2","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/15 04:31:12","14KB"},
				new String[]{"3","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/15 04:31:12","14KB"},
				new String[]{"4","[zk1 - Help] RE: Times_Series Chart help","2008/11/15 03:26:37","14KB"},
				new String[]{"5","[zk1 - Help] RE: Times_Series Chart help","2008/11/15 03:26:37","14KB"},
				new String[]{"6","[zk1 - Help] RE: Times_Series Chart help","2008/11/15 03:26:37","14KB"},
				new String[]{"7","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 12:41:33","14KB"},
				new String[]{"8","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 02:41:33","14KB"},
				new String[]{"9","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 02:41:33","14KB"},
				new String[]{"10","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 02:41:33","14KB"},
				new String[]{"11","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
				new String[]{"12","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
				new String[]{"13","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
				new String[]{"14","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
			}			
		};
		GroupsModel model = new SimpleGroupsModel(datas,new String[]{"Date: Today", "Date: Yesterday", "Date: Last Week"});
	</zscript>
	Please click the left icon of "Date: Today", than you should see the list of "Date: Yesterday" display correctly.
	<grid id="lb1" mold="paging" height="400px" model="&#36;{model}" rowRenderer="&#36;{renderer}">
	 	<columns sizable="true">
    	   <column width="80px" label="From"/>
	       <column label="Subject"/>
	       <column width="150px" label="Received"/>
	       <column width="50px" label="Size"/>
         </columns>
	</grid>
</zk>
      """

    runZTL(zscript,
      () => {

        waitResponse();
        
        //Click button
        var img = jq(".z-group-img");
        click(img);

        waitResponse();

        //Search yesterday rows
        var yrows = jq(".z-row:contains(\"2008/11/17\")");
        var len = yrows.length();

        //Verify if all yesterday rows exists
        verifyEquals(len, 15);

        for (i <- 0 to 14) {
          var b = yrows.eq(i).isVisible();
          verifyTrue(b);
        }
                
      });
  }
}