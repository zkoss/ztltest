package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2595.zul")
class B70_ZK_2595Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2595.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Jan 23, 2015 10:08:55 AM, Created by hanhsu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<style>
	.blue {
		border: solid 1px blue;
	}
	.red {
		border: solid 1px red;
	}
	.green {
		border: solid 1px green;
	}
	.black {
		border: solid 1px black;
	}
	</style>
	Please click the button "add newChild" and the size fo black area inside blue area should be up to date
	<hlayout id="container1" width="1800px">
		<div hflex="1">
			<div hflex="1" class="blue">
				<div class="black" hflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" hflex="1">
		red
		</div>
		<div class="green" hflex="1">
		green
		</div>
	</hlayout>
	<separator />
	<hbox id="container2" width="1800px">
		<div hflex="1">
			<div hflex="1" class="blue">
				<div class="black" hflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" hflex="1">
		red
		</div>
		<div class="green" hflex="1">
		green
		</div>
	</hbox>
	<separator />
	<vlayout id="container3" height="300px">
		<div vflex="1">
			<div vflex="1" class="blue">
				<div class="black" vflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" vflex="1">
		red
		</div>
		<div class="green" vflex="1">
		green
		</div>
	</vlayout>
	<separator />
	<vbox id="container4" height="300px">
		<div vflex="1">
			<div vflex="1" class="blue">
				<div class="black" vflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" vflex="1">
		red
		</div>
		<div class="green" vflex="1">
		green
		</div>
	</vbox>
	<separator />
	<button label="add newChild">
		<attribute name="onClick">
		container1.appendChild(container1.getLastChild().clone());
		container2.appendChild(container2.getLastChild().clone());
		container3.appendChild(container3.getLastChild().clone());
		container4.appendChild(container4.getLastChild().clone());
		</attribute>
	</button>
</zk>

    
"""
    runZTL(zscript,
      () => {
        var hlayout = jq(".z-hlayout");
        var hChildren = hlayout.children()
        var hChildrenSize = hChildren.eval("size()");
        var hChildWidth = hlayout.width() / hChildrenSize.toInt;
        var index = 0
        while (index < 3) {
          var t = hChildren.eq(index)
          verifyTrue(t.css("width") == hChildWidth + "px");
          index += 1
        }

        var hbox = jq(".z-hbox").toWidget();
        var hboxChild = hbox.firstChild();
        var hboxChildWidth = jq(".z-hbox").width() / hbox.nChildren();
        for (i <- 0 to 2) {
          var s = "td[id=\"" + hboxChild.uuid() + "-chdex" + "\"]";
          verifyTrue(getEval("Math.abs(" + hboxChildWidth + "-" + jq(s).width() + ") < 10)"))
          hboxChild = hboxChild.nextSibling();
        }

        var vlayout = jq(".z-vlayout")
        var vChildren = vlayout.children()
        var vChildrenSize = vChildren.eval("size()");
        var vChildWidth = vlayout.height() / vChildrenSize.toInt;
        index = 0
        while (index < 3) {
          var t = vChildren.eq(index)
          verifyTrue(t.css("height") == vChildWidth + "px");
          index += 1
        }

        var vbox = jq(".z-vbox").toWidget()
        var vboxChild = vbox.firstChild();
        var vboxChildHeight = jq(".z-vbox").height() / vbox.nChildren();
        for (i <- 0 to 2) {
          var s = "tr[id=\"" + vboxChild.uuid() + "-chdex" + "\"]";
          verifyTrue(getEval("Math.abs(" + vboxChildHeight + "-" + jq(s).height() + ") < 10)"))
          vboxChild = vboxChild.nextSibling();
        }

        click(jq("@button"));
        waitResponse();

        hlayout = jq(".z-hlayout");
        hChildren = hlayout.children()
        hChildrenSize = hChildren.eval("size()");
        hChildWidth = hlayout.width() / hChildrenSize.toInt;
        index = 0
        while (index < 4) {
          var t = hChildren.eq(index)
          verifyTrue(t.css("width") == hChildWidth + "px");
          index += 1
        }

        hbox = jq(".z-hbox").toWidget();
        hboxChild = hbox.firstChild();
        hboxChildWidth = jq(".z-hbox").width() / hbox.nChildren();
        for (i <- 0 to 3) {
          var s = "td[id=\"" + hboxChild.uuid() + "-chdex" + "\"]";
          verifyTrue(getEval("Math.abs(" + hboxChildWidth + "-" + jq(s).width() + ") < 10)"))
          hboxChild = hboxChild.nextSibling();
        }

        vlayout = jq(".z-vlayout");
        vChildren = vlayout.children()
        vChildrenSize = vChildren.eval("size()");
        vChildWidth = vlayout.height() / vChildrenSize.toInt;
        while (index < 4) {
          var t = vChildren.eq(index)
          verifyTrue(t.css("height") == vChildWidth + "px");
          index += 1
        }

        vbox = jq(".z-vbox").toWidget();
        vboxChild = vbox.firstChild();
        vboxChildHeight = jq(".z-vbox").height() / vbox.nChildren();
        for (i <- 0 to 3) {
          var s = "tr[id=\"" + vboxChild.uuid() + "-chdex" + "\"]";
          verifyTrue(getEval("Math.abs(" + vboxChildHeight + "-" + jq(s).height() + ") < 10)"))
          vboxChild = vboxChild.nextSibling();
        }
      })

  }
}