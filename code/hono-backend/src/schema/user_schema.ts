import { z } from "zod";

const userSchema = z.object({
    name: z.optional(z.string()),
    email: z.string().email("email salah"),
    age: z.number().int().min(18, "Age must be at least 18"),
});

type UserParam = {
    search?: string
}

type UserDTO = z.infer<typeof userSchema>;
export default userSchema;
export type { UserDTO, UserParam }