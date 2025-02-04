import { Hono } from 'hono'
import { PrismaClient } from "@prisma/client";

const app = new Hono()
const prisma = new PrismaClient();

app.get('/', async (c) => {
  const count = await prisma.user.count();
  const results = await prisma.user.findMany();
  return c.json({ count, results })
})
app.post('/create', async (c) => {
  const { name, email } = await c.req.json();
  await prisma.user.create({
    data: {
      name,
      email,
    },
  });
  return c.json({ name, email })
})

app.post('/update', async (c) => {
  const { id, name, email } = await c.req.json();
  await prisma.user.update({
    where: {
      id,
    },
    data: {
      name,
      email,
    },
  });
  return c.json({ id, name, email })
})

app.post('/delete', async (c) => {
  const { id } = await c.req.json();
  await prisma.user.delete({
    where: {
      id,
    },
  });
  return c.json({ id })
})

export default app
