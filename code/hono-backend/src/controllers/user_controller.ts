import type { Context } from "hono";
import userSchema from "../schema/user_schema";
import { z } from "zod";
import handleZodError from "../utils/handle_zod_error";
import { userRepository } from "../repositories/user_repository";

export const userController = {
    getAll: async (c: Context) => {
        try {
            const params = c.req.query();
            const results = await userRepository.getAll(params);
            return c.json({
                status: "Success",
                results,
                params
            });
        } catch {
            return c.json({ status: "error", message: "Unknown error occurred" }, 500);
        }
    },
    getById: async (c: Context) => {
        try {
            const id = c.req.param("id");
            const results = await userRepository.getById({ id: Number(id) });
            return c.json({
                status: "Success",
                results
            });
        } catch {
            return c.json({ status: "error", message: "Unknown error occurred" }, 500);
        }
    },
    create: async (c: Context) => {
        try {
            const body = await c.req.json();
            const validatedData = userSchema.parse(body);
            await userRepository.create(validatedData);
            return c.json({
                status: "ok",
                ...validatedData,
            });
        } catch (error: unknown) {
            if (error instanceof z.ZodError) {
                return handleZodError(c, error);
            }
            return c.json({ status: "error", message: "Unknown error occurred" }, 500);
        }
    },
}