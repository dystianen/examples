import ex from "@/server/_ex";
import HealthController from "@/server/controllers/health.controller";
import { Hono } from "hono";
import { handle } from "hono/vercel";


// =================== START GROUPING ROUTES ====================
// you can create a group of routes that share the same prefix
// this is the main route dont edit for example the lokio 
const main = new Hono().get("/health", HealthController);

/**
 * Example route group
 * const example = new Hono()
 * .get("/endpoint", ExampleController)
 * .post("/endpoint-post", ExamplePostController)
 */

// GENERETE ROUTED HERE (DONT EDIT THIS LINE)
// =================== END GROUPING ROUTES ====================

/**
 * MAIN ROUTE
 * this is the main route
 * you call the group routes in here
 * i suggest making grouping routes every new endpoint
 */
const app = new Hono().basePath("/api")
    .route("", ex)
    .route("/main", main);

/**
 * Example route
 * const app = new Hono().basePath("/api")
 * .route("", ex)
 * .route("/main", main)
 * .route("/example", example);
 * 
 * Do this to make a new route
 */

export const GET = handle(app);
export const POST = handle(app);
export type AppType = typeof app;
