import { Hono } from "hono";
import { userController } from "../controllers/user_controller";

const user_router = new Hono()
    .get("/", userController.getAll)
    .get("/:id", userController.getById)
    .post("/create", userController.create)

export default user_router;
