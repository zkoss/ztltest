package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-2882.zul")
class B80_ZK_2882Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2882.zul

	Purpose:
		
	Description:
		
	History:
		Tue Sep 22 15:23:47 CST 2015, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript><![CDATA[
	    public class Pojo {
	    	private String name; 
	    	private String status;
	    	public Pojo(String name, String status) {
	    		this.name = name;
	    		this.status = status;	    		
	    	}
	    	public String getName() {return name;}
	    	public String getStatus() {return status;}
	    	public void setName(String name) {this.name = name;}
	    	public void setStatus(String status) {this.status = status;}
	    }
	                  
		Pojo[] outer = {new Pojo("aaa", "111"), new Pojo("bbb", "111"), new Pojo("bbb", "111")};
		ListModelList outerModel = new ListModelList(outer);

		String[] statusChoices = {"111", "222", "333"};
	]]></zscript>

	<div apply="org.zkoss.bind.BindComposer">
		<label multiline="true">
		FAILS (nesting default variable 'each')
		1. Please select each comboitem, and then you should not see any Java exception.
		</label>
		<grid model="@init(outerModel)">
			<template name="model">
				<row>
					<label value="@init(each.name)"/>
					<combobox model="@init(statusChoices)" selectedItem="@bind(each.status)">
						<template name="model">
							<comboitem value="${each}" label="${each}"/>
						</template>
					</combobox>
				</row>
			</template>
		</grid>
		
		FAILS (nesting custom template variable 'myvar')
		<grid model="@init(outerModel)">
			<template name="model" var="myvar">
				<row>
					<label value="@init(myvar.name)"/>
					<combobox model="@init(statusChoices)" selectedItem="@bind(myvar.status)">
						<template name="model" var="myvar">
							<comboitem value="${myvar}" label="${myvar}"/>
						</template>
					</combobox>
				</row>
			</template>
		</grid>

		WORKS (defining unique template var names)
		<grid model="@init(outerModel)">
			<template name="model">
				<row>
					<label value="@init(each.name)"/>
					<combobox model="@init(statusChoices)" selectedItem="@bind(each.status)">
						<template name="model" var="choice">
							<comboitem value="${choice}" label="${choice}"/>
						</template>
					</combobox>
				</row>
			</template>
		</grid>

		WORKS (defining unique template var names)
		<grid model="@init(outerModel)">
			<template name="model" var="pojo">
				<row>
					<label value="@init(pojo.name)"/>
					<combobox model="@init(statusChoices)" selectedItem="@bind(pojo.status)">
						<template name="model">
							<comboitem value="${each}" label="${each}"/>
						</template>
					</combobox>
				</row>
			</template>
		</grid>
	</div>
</zk>

  """
    runZTL(zscript,
      () => {
        //click the 1st combobox button in the 1st grid
        click(jq(".z-grid:eq(0) .z-combobox-button").eq(0))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(1))
        waitResponse()
        //click the 2nd combobox button in the 1st grid
        click(jq(".z-grid:eq(0) .z-combobox-button").eq(1))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(1))
        waitResponse()
        //click the 3rd combobox button in the 1st grid
        click(jq(".z-grid:eq(0) .z-combobox-button").eq(2))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(1))
        waitResponse()
        //check the all input should be 222
        var iter = jq("input").iterator()
        while (iter.hasNext()) {
          verifyEquals("222", iter.next().`val`())
        }

        //click the 1st combobox button in the 2nd grid
        click(jq(".z-grid:eq(1) .z-combobox-button").eq(0))
        waitResponse()
        //select the 1st item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(0))
        waitResponse()
        //click the 2nd combobox button in the 1st grid
        click(jq(".z-grid:eq(1) .z-combobox-button").eq(1))
        waitResponse()
        //select the 1st item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(0))
        waitResponse()
        //click the 3rd combobox button in the 1st grid
        click(jq(".z-grid:eq(1) .z-combobox-button").eq(2))
        waitResponse()
        //select the 1st item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(0))
        waitResponse()
        //check the all input should be 111
        iter = jq("input").iterator()
        while (iter.hasNext()) {
          verifyEquals("111", iter.next().`val`())
        }

        //click the 1st combobox button in the 3rd grid
        click(jq(".z-grid:eq(2) .z-combobox-button").eq(0))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(1))
        waitResponse()
        //click the 2nd combobox button in the 3rd grid
        click(jq(".z-grid:eq(2) .z-combobox-button").eq(1))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(1))
        waitResponse()
        //click the 3rd combobox button in the 3rd grid
        click(jq(".z-grid:eq(2) .z-combobox-button").eq(2))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(1))
        waitResponse()
        //check the all input should be 222
        iter = jq("input").iterator()
        while (iter.hasNext()) {
          verifyEquals("222", iter.next().`val`())
        }

        //click the 1st combobox button in the 4th grid
        click(jq(".z-grid:eq(3) .z-combobox-button").eq(0))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(2))
        waitResponse()
        //click the 2nd combobox button in the 4th grid
        click(jq(".z-grid:eq(3) .z-combobox-button").eq(1))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(2))
        waitResponse()
        //click the 3rd combobox button in the 4th grid
        click(jq(".z-grid:eq(3) .z-combobox-button").eq(2))
        waitResponse()
        //select the 2nd item
        click(jq(".z-combobox-popup.z-combobox-open .z-comboitem").eq(2))
        waitResponse()
        //check the all input should be 333
        iter = jq("input").iterator()
        while (iter.hasNext()) {
          verifyEquals("333", iter.next().`val`())
        }
        //check there are no errors
        verifyFalse(hasError())
      })
  }
}