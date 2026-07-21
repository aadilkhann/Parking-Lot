# Proposed Roadmap

## Phase 1 — Payment System ⭐ (Recommended)

Currently your flow is:

```text
Park Vehicle

↓

Allocate Spot

↓

Generate Ticket

↓

Unpark

↓

Free Spot
```

A real parking lot is:

```text
Park

↓

Ticket

↓

Unpark

↓

Calculate Fee

↓

Payment

↓

Receipt

↓

Free Spot
```

This will naturally introduce:

* PaymentService
* FeeCalculator
* PaymentStrategy
* Receipt
* Transaction lifecycle

We'll discuss questions like:

* Who owns payment?
* When should the spot actually become free?
* What happens if payment fails?

This is how enterprise systems are designed.

---

## Phase 2 — Multiple Pricing Rules

Example:

```
Bike
₹20/hr

Car
₹40/hr

Truck
₹80/hr

Weekend

Night

Holiday

VIP
```

Now the question becomes:

Who calculates the fee?

This naturally introduces another Strategy Pattern.

---

## Phase 3 — Reservation

Example:

```
Reserve spot

↓

Expire reservation

↓

Confirm arrival

↓

Cancel reservation
```

Now we have state transitions.

This naturally introduces the **State Pattern**.

---

## Phase 4 — Display Boards

Parking lot entrance:

```
Floor 1

Bike : 12

Car : 3

Truck : 1
```

Whenever parking changes:

```
Display updates
```

Nobody should manually call:

```
display.update()
```

This naturally introduces the **Observer Pattern**.

---

## Phase 5 — Admin Panel

```
Close Floor

Open Floor

Maintenance

Disable Spot
```

Now strategies need to ignore unavailable spots.

---

## Phase 6 — Concurrency

The fun part.

Imagine:

```
Two cars

↓

Same spot
```

We'll discuss:

* synchronized
* Locks
* Race conditions
* Atomicity

---

# My Suggested Order

I'd go:

```
V2.1 Payment

↓

V2.2 Pricing

↓

V2.3 Reservation

↓

V2.4 Display Board

↓

V2.5 Concurrency
```

Each phase introduces one new design concept.

---

# How I Want to Conduct V2

Exactly like we did V1.

I **won't** say:

> "Use Strategy here."

Instead I'll be the interviewer.

For example:

---

**Interviewer:**

> The business team has a new requirement.

Customers should pay before exiting.

Supported methods:

* Cash
* Credit Card
* UPI

Additionally:

* If payment fails, the gate must remain closed.
* The parking spot should **not** become available until payment succeeds.

How would you modify your current design?

---

Notice what I'm **not** saying.

I'm not asking:

> "Implement Strategy Pattern."

I'm asking about the business problem.

If your design naturally arrives at a Payment Strategy and a well-defined payment workflow, you'll know you're thinking like a designer rather than applying patterns by rote.

---

## One small rule for V2

In V1, I occasionally nudged you toward a pattern because you were still building intuition.

In V2, I'll do much less of that.

I'll mostly ask questions, challenge assumptions, and review your design decisions. If you end up using a pattern, it should be because **the requirements pulled you there**, not because you remembered a catalog of patterns.

I think you're ready for that style now.
