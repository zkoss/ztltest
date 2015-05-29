package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper
import org.openqa.selenium.Keys

@Tags(tags = "B80-ZK-2708.zul")
class B80_ZK_2708Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<!--
F80-ZK-2708.zul

  Purpose:
    
  Description:
    
  History:
    Mon, May 04, 2015 02:30:24 PM, Created by jameschu
Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:n="native">
  <style>
  .z-rowlayout:hover {
    background-color: #84FFB9;
  }
  </style>
  <n:p>Please enter content directly into window to change its height.</n:p>
  <n:b>Default: ncols=12, spacing=1/3</n:b>
  <rowlayout>
    <rowchildren forEach="1,1,1,1,1,1,1,1,1,1,1,1" colspan="${each}">
      <window border="normal" title="colspan=1" hflex="1" />
    </rowchildren>
  </rowlayout>
  <separator orient="horizontal" spacing="5px"/>
  <rowlayout>
    <rowchildren forEach="2,2,2,2,2,2" colspan="${each}">
      <window border="normal" title="colspan=2" hflex="1" />
    </rowchildren>
  </rowlayout>
  <separator orient="horizontal" spacing="5px"/>
  <rowlayout>
    <rowchildren forEach="3,3,3,3" colspan="${each}">
      <window border="normal" title="colspan=3" hflex="1" />
    </rowchildren>
  </rowlayout>
  <separator orient="horizontal" spacing="5px"/>
  <rowlayout>
    <rowchildren forEach="4,4,4" colspan="${each}">
      <window border="normal" title="colspan=4" hflex="1" />
    </rowchildren>
  </rowlayout>
  <separator orient="horizontal" spacing="5px"/>
  <rowlayout>
    <rowchildren forEach="6,6" colspan="${each}">
      <window border="normal" title="colspan=6" hflex="1" />
    </rowchildren>
  </rowlayout>
  <separator orient="horizontal" spacing="5px"/>
  <rowlayout>
    <rowchildren forEach="12" colspan="${each}">
      <window border="normal" title="colspan=12" hflex="1" />
    </rowchildren>
  </rowlayout>

  <n:b>offset=10, first child</n:b>
  <rowlayout>
    <rowchildren offset="10">
      <window border="normal" title="offset=10" hflex="1" />
    </rowchildren>
    <rowchildren>
      <window border="normal" title="colspan=1" hflex="1" />
    </rowchildren>    
  </rowlayout>
  
  <n:b>offset=10, subsequent child</n:b>
  <rowlayout>
    <rowchildren>
      <window border="normal" title="colspan=1" hflex="1" />
    </rowchildren>
    <rowchildren offset="10">
      <window border="normal" title="offset=10" hflex="1" />
    </rowchildren>    
  </rowlayout>
  <separator />
  <separator /> 
  <n:b>Using MVVM to control rowlayout's parameters</n:b>
  <window 
    apply="org.zkoss.bind.BindComposer" 
    viewModel="@id('vm') @init('org.zkoss.zktest.test2.F80_ZK_2708_VM')">
    <rowlayout ncols="10" spacing="1/12">
      <rowchildren>ncols</rowchildren>
      <rowchildren>
        <spinner hflex="1" instant="true" value="@bind(vm.ncols)" constraint="no empty,min 1 max 12"/>
      </rowchildren>
      <rowchildren>spacing</rowchildren>
      <rowchildren>
        <textbox hflex="1" value="@bind(vm.spacing)" />
      </rowchildren>
    </rowlayout>
    
    <rowlayout id="rowlayout1" ncols="@bind(vm.ncols)" spacing="@bind(vm.spacing)">
      <rowchildren forEach="1,1,1,1,1,1,1,1,1,1,1,1" colspan="${each}">
        <window border="normal" title="colspan=1" hflex="1" />
      </rowchildren>
    </rowlayout>
  </window>
  <separator />
  <separator /> 
  <n:h2>Reference: ncols = 12, spacing = 1/3</n:h2>
  <window>
    <rowlayout>
      <rowchildren forEach="1,1,1,1,1,1,1,1,1,1,1,1" colspan="${each}">
        <window border="normal" title="colspan=1" hflex="1" />
      </rowchildren>
    </rowlayout>
  </window>
  
  <n:h2>Rowchildren: colspan and offset</n:h2>
  <window id="win" apply="org.zkoss.zktest.test2.F80_ZK_2708_Composer">
    <hlayout>
      colspan: <spinner id="colspan" value="1" constraint="no empty,min 1 max 12" />
      offset:  <spinner id="offset" value="0" constraint="no empty,min 0 max 11" />
      <button id="add">Add child</button>
    </hlayout>  
  </window>
    
  <script defer="true">
  jq('.z-window-embedded-cnt')
    .attr('contentEditable', '')
    .css('min-height', '30px');
  </script>
</zk>

""" 
  def abs(x: Int) = if (x >=0) x else -x;
  runZTL(zscript,
    () => {
      var rowlayout = jq(".z-rowlayout").eq(0);
      var totalWidth = rowlayout.outerWidth();
      var childrenWidth = 0;
      for (i <- 0 to rowlayout.children().length()-1) {
        var rowchildren = rowlayout.children().eq(i);
        if (i > 0) {
          var rowchildrenpre = rowlayout.children().eq(i - 1);
          verifyTrue(abs(rowchildren.width() - rowchildrenpre.width()) < 2);
        }
        childrenWidth += rowchildren.outerWidth(true);
      }
      verifyTrue(abs(totalWidth - childrenWidth) < 10);
      
      rowlayout = jq(".z-rowlayout").eq(6);
      totalWidth = rowlayout.outerWidth();
      childrenWidth = 0;
      for (i <- 0 to rowlayout.children().length()-1) {
        var rowchildren = rowlayout.children().eq(i);
        if (i > 0) {
          var rowchildrenpre = rowlayout.children().eq(i - 1);
          verifyTrue(abs(rowchildren.width() - rowchildrenpre.width()) < 2);
          //test offset
          verifyTrue(rowchildren.outerWidth(true) < rowchildrenpre.outerWidth(true));
        }
        childrenWidth += rowchildren.outerWidth(true);
      }
      verifyTrue(abs(totalWidth - childrenWidth) < 10);
      
      rowlayout = jq(".z-rowlayout").eq(9);
      totalWidth = rowlayout.outerWidth();
      childrenWidth = 0;
      for (i <- 0 to rowlayout.children().length()-1) {
        var rowchildren = rowlayout.children().eq(i);
        if (i > 0) {
          var rowchildrenpre = rowlayout.children().eq(i - 1);
          verifyTrue(abs(rowchildren.width() - rowchildrenpre.width()) < 2);
        }
        childrenWidth += rowchildren.outerWidth(true);
      }
      verifyTrue(abs(totalWidth - childrenWidth) < 10);
      
      var spinner = jq(".z-spinner-input");
      sendKeys(spinner, Keys.ARROW_DOWN);
      waitResponse();
      totalWidth = rowlayout.outerWidth();
      childrenWidth = 0;
      verifyTrue(rowlayout.children().length() == 11);
      for (i <- 0 to rowlayout.children().length()-1) {
        var rowchildren = rowlayout.children().eq(i);
        if (i > 0) {
          var rowchildrenpre = rowlayout.children().eq(i - 1);
          verifyTrue(abs(rowchildren.width() - rowchildrenpre.width()) < 2);
        }
        childrenWidth += rowchildren.outerWidth(true);
      }
      verifyTrue(abs(totalWidth - childrenWidth) < 10);
    })
    
  }
}