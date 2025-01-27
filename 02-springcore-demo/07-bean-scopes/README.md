## Bean Scope and Bean life cycle

- Singelton, Prototype, etc

Life cycle is important as we can use hooks at each step of the cycle:
- post initialization
- pre destroy
- etc

a note about prototype with bean lifecycle

Prototype Beans and Destroy Lifecycle
There is a subtle point you need to be aware of with "prototype" scoped beans.

For "prototype" scoped beans, Spring does not call the destroy method. Gasp!

---

In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.

Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.

