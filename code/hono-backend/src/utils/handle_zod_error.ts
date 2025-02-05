import type { Context } from "hono";
import type { z } from "zod";

function handleZodError(c: Context, error: z.ZodError) {
    return c.json({
        status: "error",
        errors: error.errors.map(err => ({
            field: err.path.join("."),
            message: err.message
        }))
    }, 400);
}

export default handleZodError
