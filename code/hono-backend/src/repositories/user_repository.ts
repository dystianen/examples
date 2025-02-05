import { prisma } from "../pkg/prisma/main"
import type { UserDTO, UserParam } from "../schema/user_schema"

export const userRepository = {
    getAll: async (params: UserParam) => {
        console.error({ params });
        const results = await prisma.user.findMany()
        return results
    },
    getById: async ({ id }: { id: number }) => {
        const results = await prisma.user.findFirst({
            where: {
                id
            }
        })
        return results
    },
    create: async (payload: UserDTO) => {
        return await prisma.user.create({
            data: {
                email: payload.email,
                name: payload.name,
            }
        })
    }
}