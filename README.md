A project for collecting [ZK](http://www.zkoss.org/) test cases
=========================================

About TestCafe
--------------

These test cases are written using [TestCafe](https://testcafe.io/), a Node.js-based end-to-end testing framework that requires no WebDriver or browser plugins. It supports modern browsers out of the box and allows tests to be written in plain JavaScript or TypeScript.

ZTL test cases have migrated from the old Scala-based ZTL framework to TestCafe JS files. The legacy Scala test files can still be found at [ztl-scala](https://github.com/zkoss/ztltest/tree/ztl-scala).

- TestCafe documentation: https://testcafe.io/documentation/402635/guides/overview/getting-started

How to run ztltest
------------------

#### 1. Start the ZK zktest server ####

You need to first run the `zktest` web application from the [ZK repository](https://github.com/zkoss/zk) on your local machine. 

The server should be available at `http://localhost:8080/zktest`. Each test file contains a URL pointing to this server (e.g., `http://localhost:8080/zktest/ztl.zul`), so make sure the server is up before running tests.

#### 2. Install dependencies ####

```bash
npm install
```

#### 3. Run tests with TestCafe ####

Run a single test file:

```bash
npx testcafe chrome org/zkoss/zktest/test2/B30/B30-1455584TestCafe.js
```

Run all tests under a folder:

```bash
npx testcafe chrome org/zkoss/zktest/test2/B30/
```

You can replace `chrome` with other browsers such as `firefox`, `safari`, or `edge`.




How to refine test cases
------------------------------

The current TestCafe JS files were converted from the original Scala-based ZTL test cases. As a result, some files may contain machine-generated code that could be simplified or improved for readability and maintainability.

When refining a test case, refer to the corresponding Scala source file in the [ztl-scala](https://github.com/zkoss/ztltest/tree/ztl-scala) branch to better understand the original test intent, then rewrite or clean up the TestCafe JS version using proper TestCafe syntax.

The naming convention between the two is:

| TestCafe file | Corresponding Scala file |
|---|---|
| `B30-1455584TestCafe.js` | `B30_1455584Test.scala` |

In general: replace `-` with `_`, drop the `TestCafe` suffix, and add `Test` in its place.
