
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-144.zul,Flex")
class Z65_Flex_144Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="data flex test: [tree,span,hflex=1,width=120px,hflex=min]" width="480px">
        <tree>
            <treecols>
                <treecol hflex="1" label="hflex=1"/>
                <treecol label="width=120px" width="120px"/>
                <treecol hflex="min" label="hflex=min"/>
            </treecols>
            <treechildren>
                <treeitem>
                    <treerow>
                        <treecell label="item 1" span="2" style="background: cyan"/>
                        <treecell label="item 1" width="120px"/>
                    </treerow>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 2"/>
                        <treecell label="item 2 desc" width="120px"/>
                        <treecell label="item 2"/>
                    </treerow>
                    <treechildren>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.1"/>
                            </treerow>
                        </treeitem>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.2"/>
                                <treecell label="Item 2.2 desc" width="120px"/>
                            </treerow>
                        </treeitem>
                    </treechildren>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 3"/>
                        <treecell label="item 3 desc" span="2"
                            style="background: cyan" width="120px"/>
                    </treerow>
                </treeitem>
            </treechildren>
        </tree>
    </window>
    <window border="normal" height="360px"
        title="data flex test: [tree,hflex=1,width=120px,hflex=min]" width="480px">
        <tree>
            <treecols>
                <treecol hflex="1" label="hflex=1"/>
                <treecol label="width=120px" width="120px"/>
                <treecol hflex="min" label="hflex=min"/>
            </treecols>
            <treechildren>
                <treeitem>
                    <treerow>
                        <treecell label="item 1"/>
                        <treecell label="item 1 desc" width="120px"/>
                        <treecell label="item 1"/>
                    </treerow>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 2"/>
                        <treecell label="item 2 desc" width="120px"/>
                        <treecell label="item 2"/>
                    </treerow>
                    <treechildren>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.1"/>
                            </treerow>
                        </treeitem>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.2"/>
                                <treecell label="Item 2.2 desc" width="120px"/>
                            </treerow>
                        </treeitem>
                    </treechildren>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 3"/>
                        <treecell label="item 3 desc" width="120px"/>
                        <treecell label="item 3"/>
                    </treerow>
                </treeitem>
            </treechildren>
        </tree>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="data flex test: [tree,span,hflex=2,width=120px,hflex=1]" width="480px">
        <tree>
            <treecols>
                <treecol hflex="2" label="hflex=2"/>
                <treecol label="width=120px" width="120px"/>
                <treecol hflex="1" label="hflex=1"/>
            </treecols>
            <treechildren>
                <treeitem>
                    <treerow>
                        <treecell label="item 1" span="2" style="background: cyan"/>
                        <treecell label="item 1" width="120px"/>
                    </treerow>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 2"/>
                        <treecell label="item 2 desc" width="120px"/>
                        <treecell label="item 2"/>
                    </treerow>
                    <treechildren>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.1"/>
                            </treerow>
                        </treeitem>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.2"/>
                                <treecell label="Item 2.2 desc" width="120px"/>
                            </treerow>
                        </treeitem>
                    </treechildren>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 3"/>
                        <treecell label="item 3 desc" span="2"
                            style="background: cyan" width="120px"/>
                    </treerow>
                </treeitem>
            </treechildren>
        </tree>
    </window>
    <window border="normal" height="360px"
        title="data flex test: [tree,hflex=2,width=120px,hflex=1]" width="480px">
        <tree>
            <treecols>
                <treecol hflex="2" label="hflex=2"/>
                <treecol label="width=120px" width="120px"/>
                <treecol hflex="1" label="hflex=1"/>
            </treecols>
            <treechildren>
                <treeitem>
                    <treerow>
                        <treecell label="item 1"/>
                        <treecell label="item 1 desc" width="120px"/>
                        <treecell label="item 1"/>
                    </treerow>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 2"/>
                        <treecell label="item 2 desc" width="120px"/>
                        <treecell label="item 2"/>
                    </treerow>
                    <treechildren>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.1"/>
                            </treerow>
                        </treeitem>
                        <treeitem>
                            <treerow>
                                <treecell label="Item 2.2"/>
                                <treecell label="Item 2.2 desc" width="120px"/>
                            </treerow>
                        </treeitem>
                    </treechildren>
                </treeitem>
                <treeitem>
                    <treerow>
                        <treecell label="item 3"/>
                        <treecell label="item 3 desc" width="120px"/>
                        <treecell label="item 3"/>
                    </treerow>
                </treeitem>
            </treechildren>
        </tree>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}